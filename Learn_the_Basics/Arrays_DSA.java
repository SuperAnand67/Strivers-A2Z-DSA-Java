import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Solutions{

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
}

public class Arrays_DSA {

    public static void printArray(int[] arr){

        System.out.print("Array : ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void getElements(int[] arr, Scanner sc){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static int[] arrayCreate(int n,Scanner sc){
        int[] arr = new int[n];

        getElements(arr, sc);

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solutions sol = new Solutions();

        int n = sc.nextInt();

        int[] arr = new int[n];

        //for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        getElements(arr, sc);
        int[] cpy = arr.clone();

        printArray(arr);

        System.out.print("Sorted Array : ");
        Arrays.sort(cpy);
        System.out.println(Arrays.toString(cpy));

        System.out.println("Largest Element : " + 
            sol.largest_element(arr)
        );
        
        System.out.println(
            "Second Largest Element : " + 
            sol.secondLargest_optimal(arr)
        );

        System.out.println(
            sol.isSorted(arr) ? "Sorted" : "Not Sorted"
        );

        System.out.println();

        int[] arr2 = new int[n + 1];

        //for (int i = 0; i < n+1; i++) arr2[i] = sc.nextInt();

        getElements(arr2, sc);

        printArray(arr2);

        System.out.println(
            "Unique Elements : " + sol.removeDuplicates(arr2)
        );
        printArray(arr2);

        System.out.println();

        int[] array = new int[n];

        //for (int i = 0; i < n; i++) array[i] = sc.nextInt();

        getElements(array, sc);

        printArray(array);
        sol.leftRotateOne(array);
        System.out.println("After Left Rotaion By one Place");
        printArray(array);

        Arrays.sort(array);

        int r = sc.nextInt();
        sol.leftRotateByK(array,r);
        System.out.println("After Left Rotation by " + r + " Places");
        printArray(array);

        Arrays.sort(array);

        sol.rightRotate(array,r);
        System.out.println("After Right Rotation by " + r + " Places");
        printArray(array);

        System.out.println();

        int[] move = arrayCreate(n+1, sc);
        printArray(move);
        System.out.println("After Moving Zero's to the End");
        sol.moveZeros(move);
        printArray(move);

        System.out.println();
        printArray(cpy);
        int target = sc.nextInt();
        int index = sol.linear_search(cpy, target);
        if (index == -1)
            System.out.println("Element " + target + " Not Found !");
        else
            System.out.printf("Element %d present at index %d\n",target,index);

        System.out.println();

        int n2 = sc.nextInt();
        int[] a1 = arrayCreate(n, sc);
        int[] a2 = arrayCreate(n2, sc);
        printArray(a1);
        printArray(a2);
        System.out.println("Union : " + sol.union(a1, a2));

        sc.close();
    }
}
