import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solutions{

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

    // TC -> O(2n) +> O(n)
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
            if (arr[i] != arr[j])
                swap(arr, ++i, j);
        }

        return i+1;
    }
}

public class Arrays_DSA {

    public static void printArray(int[] arr){

        System.out.print("Array : ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solutions sol = new Solutions();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
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

        for (int i = 0; i < n+1; i++) arr2[i] = sc.nextInt();

        printArray(arr2);

        System.out.println(
            "Unique Elements : " + sol.removeDuplicates(arr2)
        );

        printArray(arr2);

        sc.close();
    }
}
