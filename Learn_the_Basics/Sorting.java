import java.util.Arrays;
import java.util.Scanner;

class SortingAlgo {

    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // TC -> O(n^2)
    public void selection_sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            // System.err.printf("Before min-%d,i-%d ",
            //     arr[min],arr[i]);

            swap(arr ,min ,i);

            // System.err.printf("After min-%d,i-%d\n",
            //     arr[min],arr[i]);
        }
    }

    // TC -> O(n^2) [Worst and Avg]
    // TC -> O(n) [Best case]
    public void bubble_sort(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
                
                if (!swapped) break;
                // System.err.println(Arrays.toString(arr) +
                // " i = 0 to " + i + " j = " + j); 
            }
            //System.err.println("Step " + (n-i) + " -> "+
                //Arrays.toString(arr) + " i = " + i);
        }
    }

    // TC -> O(n^2) [Worst and Avg]
    // TC -> O(n) [Best case]
    public void insertion_sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            System.err.printf("Step %d -> %s\n",
                    i+1,Arrays.toString(arr));
            while (j > 0 && arr[j-1] > arr[j]) {
                swap(arr, j-1, j);
                j--;
            }
        }
    }
}

public class Sorting {

    public static void printArray(int[] arr){
        System.out.print("Array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SortingAlgo sort = new SortingAlgo();

        int n = in.nextInt();

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        printArray(arr);

        // sort.selectionSort(arr);
        // sort.bubble_sort(arr);
        sort.insertion_sort(arr);

        printArray(arr);

        in.close();
    }
}
