
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Array_Solutions{

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArray(int[] arr, int s, int e){
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int max(int a, int b){
        if(a > b)
            return a;

        return b;
    }

    public static void reverse(int[] arr, int i, int j){
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public int sumArray(int[] arr, int s, int e){
        int sum = 0;
        for (int i = s; i <= e; i++) {
           sum += arr[i]; 
        }

        return sum;
    }

    public int rangeSum(int[] prefixArray, int i, int j){
        if (i == 0) {
            return prefixArray[j];
        }

        int sum = prefixArray[j] - prefixArray[i - 1];

        return sum;
    }

    public int[] prefixSum(int[] arr){
        int n = arr.length;
        int[] prefixArray = new int[n];

        prefixArray[0] = arr[0];
        
        // for (int i = 0; i < arr.length; i++) {   // O(n^2)
        //     prefixArray[i] = sumArray(arr, 0, i);
        // }

        for (int i = 1; i < n; i++) { // O(n)
            prefixArray[i] = prefixArray[i - 1] + arr[i];
        }

        return prefixArray;
    }

    // TC -> O(n)
    public int largest_element(int[] arr){
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        return max;
    }

    // TC -> O(2n) + O(n)
    public int secondLargest(int[] arr){
        int largest = largest_element(arr);
        int second_largest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (largest != arr[i] && second_largest < arr[i])
                    second_largest = arr[i];
        }

        return second_largest;
    }
    // TC -> O(n)
    public int secondLargest_optimal(int[] arr){
        int largest = arr[0];
        int second_largest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                second_largest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > second_largest)
                second_largest = arr[i];
        }

        return second_largest;
    }

    // TC -> O(n)
    public boolean isSorted(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }

    public int removeDuplicates_brute(int[] arr){
        var uniq = new HashSet<Integer>();

        for (int i : arr)
            uniq.add(i);

        return uniq.size();
    }

    public int removeDuplicates(int[] arr){
        int i = 0;

        for (int j = 1; j < arr.length; j++){
            if (arr[i] != arr[j]){
                i++;
                swap(arr, i, j);
            }
        }

        return i+1;
    }

    // TC -> O(n)
    public void leftRotateOne(int[] arr){
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            swap(arr, i++, j);
        }
    }

    // TC -> O(n + k)
    // SC -> O(k)
    public void leftRotateByK_brute(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        int[] temp = new int[k];

        // Copying Rotated elements to a new array
        for (int i = 0; i < temp.length; i++)
            temp[i] = arr[i];

        // Shifting elements
        for (int i = k; i < arr.length; i++)
            arr[i - k] = arr[i];

        // Put Back Temp Array
        for (int i = (n - k); i < arr.length; i++)
            arr[i] = temp[i - (n - k)];
    }

    public void leftRotateByK(int[] arr, int k){
        int n = arr.length;
        k = k % n;

        reverse(arr,0,k-1);

        reverse(arr,k,n-1);

        reverse(arr);
    }

    public void rightRotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;

        reverse(arr,n - k,n - 1);

        reverse(arr,0,n - k - 1);

        reverse(arr);
    }

    public void moveZeros_brute(int[] arr){
        int n = arr.length;
        var temp = new ArrayList<Integer>(); // Temp arr for Non Zeros

        // Copy Non Zeros to Temp Array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        // Replace Non Zeros from Temp to original Array
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        // Add Zeros to Last
        for (int i = temp.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public void moveZeros(int[] arr){
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                swap(arr, i, j);
                i++;
            }
        }
    }

    public int linear_search(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public HashSet<Integer> union_brute(int[] a1, int[] a2){
        var union = new HashSet<Integer>();

        for (int i : a1) {
            union.add(i);
        }

        for (int i : a2) {
            union.add(i);
        }

        return union;
    }

    private void addUnique(ArrayList<Integer> list, int val){
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
                    list.add(val);
        }
    }

    // TC -> O(2n) -> O(n)
    public ArrayList<Integer> union(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        var union = new ArrayList<Integer>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                addUnique(union, arr1[i]);
                i++; 
            }
            else if (arr1[i] > arr2[j]) {
                addUnique(union, arr2[j]);
                j++;
            }
            else{
                addUnique(union, arr1[i]);
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            addUnique(union, arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            addUnique(union, arr2[j]);
            j++;
        }

        return union;
    }

    // TC -> O(n1 x n2)
    // SC -> O(n2)
    public ArrayList<Integer> intersection_brute(int[] a1,int[] a2){
        int n1 = a1.length;
        int n2 = a2.length;

        int[] visited = new int[n2];

        var intersection = new ArrayList<Integer>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a1[i] == a2[j] && visited[j] == 0) {
                    intersection.add(a1[i]);
                    visited[j] = 1;
                    break;
                }
                if (a2[j] > a1[i]) break;
            }
        }

        return intersection;
    }

    public ArrayList<Integer> intersection(int[] a1, int[] a2){
        int i = 0;
        int j = 0;

        var intersection = new ArrayList<Integer>();

        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) i++;
            else if(a1[i] > a2[j]) j++;
            else {
                intersection.add(a1[i]);
                i++;
                j++;
            }
            
        }

        return intersection;
    }

    // TC -> O(n^2)
    // SC -> O(n) 
    public int missing_num_better(int[] arr, int n){
        int[] hash = new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    // TC -> O(n)
    public int missing_num(int[] arr, int n){
        int sum = n * (n + 1) / 2;
        int curSum = 0;

        for (int i : arr) {
            curSum += i;
        }

        return sum - curSum;
    }

    public int missing_num_optimal(int[] arr, int n){
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
            xor1 ^= (i+1);
        }

        xor1 ^= n;

        return xor1 ^ xor2;
    }

    public int max_consecutive_ones(int[] arr){
        int count = 0;
        int max = 0;

        for (int i : arr) {
            if (i == 1) {
                count++;
                max = max(max, count);
            }
            else{
                //max = (count >= max) ? count : max;
                count = 0;
            }
        }
        return max;
    }

    // TC -> O(n^2)
    public int appear_once_brute(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == num) {
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return -1;
    }

    // TC -> O(n/2 + 1) + O(n log m)
    // SC -> O(n/2 +1)
    public int appear_once_better(int[] arr){
        //int n = arr.length;

        // int maxi = arr[0];

        // // O(n)
        // for (int i : arr) {
        //     maxi = max(maxi, i);
        // }

        // int[] hash = new int[maxi + 1];

        // // O(n)
        // for (int i = 0; i < n; i++) {
        //     hash[arr[i]]++;
        // }

        // // O(max)
        // for (int i = 0; i < hash.length; i++) {
        //     if (hash[i] == 1) {
        //         return i;
        //     }
        // }

        var hash = new HashMap<Integer, Integer>();

        // for (int i = 0; i < n; i++) {
        //     hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        // }

        // O(n)
        for (int i : arr) {
            hash.merge(i, 1, Integer::sum);
        }

        // O(n)
        for (Entry<Integer, Integer> e : hash.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }

    // TC -> O(n)
    public int appear_once(int[] arr){
        int xor = 0;

        for (int i : arr) {
            xor ^= i;
        }

        return xor;
    }

    public void printAllSubArrays(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("SubArray " + ++count + " -> ");
                printArray(arr, i, j);
            }
            System.out.println();
        }
        System.out.println("No of SubArrays : " + count);
    }

    // Returns Longest Sub Array Length with sum k
    // TC -> O(n^3) -> O(n^2)
    public int longest_subArraySum_brute(int[] arr, int k){
        int n = arr.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {      // O(n)
            int sum = 0;
            for (int j = i; j < n; j++) {   // O(n)
                //int currSum = sumArray(arr, i, j);    // O(n)
                sum += arr[j];
                if (sum == k) {
                    printArray(arr, i, j);
                    int len = j - i + 1;
                    max = max(max, len);
                }
            }
        }
        return max;
    }

    // TC -> O(n)
    // SC -> O(n)
    public int longest_subArraySum_better(int[] arr, int k){
        var prefixMap = new HashMap<Integer, Integer>();
        prefixMap.put(0, -1);
        int maxLength = 0;
        int currPrefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currPrefixSum += arr[i];
            int prevPrefixSum = currPrefixSum - k;
            if (prefixMap.containsKey(prevPrefixSum)) {
                int len = i - prefixMap.get(prevPrefixSum);
                maxLength = max(len,maxLength);
            }

            if(!prefixMap.containsKey(currPrefixSum)){
                prefixMap.put(currPrefixSum, i);
            }
        }
        return maxLength;
    }

    public int longest_subArraySum(int[] arr, int k){
        int n = arr.length;
        int sum = arr[0];
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < n) {
            while (i <= j && sum > k) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) {
                int len = j - i + 1;
                maxLen = max(maxLen, len);
            }

            j++;
            if(j < n) sum += arr[j];
            
        }
        return maxLen;
    }

    // TC -> O(n^2)
    // SC -> O(1)
    public int[] twoSum_brute(int[] arr, int target){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target)
                    return new int[] {i,j};
            }
        }

        return new int[] {-1,-1};
    }

    // TC -> O(n)
    // SC -> O(n)
    public int[] twoSum_better(int[] arr, int target){
        int n = arr.length;

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int x = target - arr[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            if (!map.containsKey(x)) {
                map.put(arr[i], i);
            }
        }
        return new int[] {-1,-1};
    }

    public int[] twoSum_sorted(int[] arr, int target){
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return new int[]{l,r};
            }
            else if (sum < target) {
                l++;
            }
            else
                r--;
        }

        return new int[]{-1,-1};
    }

    // TC -> O(2n)
    public void sort_Array_better(int[] arr){
        int count0 = 0;
        int count1 = 0;

        for (int i : arr) {
            switch (i) {
                case 0 -> count0++;
                case 1 -> count1++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }

        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    // Dutch National Flag Algorithm
    // TC -> O(n)
    public void sort_Array(int[] arr){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Element that is greater than n / 2
    // TC -> O(2n)
    // SC -> O(n)
    public int majority_element_better(int[] arr){
        int n = arr.length;

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2)) {
                return entry.getKey();
            }
        }

        return -1;
    }

    // TC -> O(2n) or if array always have majority ele -> O(n)
    // SC -> O(1)
    public int majority_element(int[] arr){
        int n = arr.length;
        int element = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            }
            else if (element == arr[i]) {
                count++;
            }
            else{
                count--;
            }
        }

        count = 0;

        for (int i : arr) {
            if (i == element) {
                count++;
            }
        }

        if (count > n/2) {
            return element;
        }
        return -1;
    }
}
