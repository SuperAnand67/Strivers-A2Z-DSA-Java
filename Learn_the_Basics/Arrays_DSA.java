
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Arrays_DSA {

    public static void printArray(int[] arr){

        System.out.print("Array : ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void printArray(int[] arr, String name){

        System.out.print(name + " : ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }


    public static int[] arrayCreate(int n,Scanner sc){
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array_Solutions sol = new Array_Solutions();
        Extra extra = new Extra();

        int n = sc.nextInt();

        int[] arr = arrayCreate(n, sc);

        //for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

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

        int[] arr2 = arrayCreate(n + 1, sc);

        //for (int i = 0; i < n+1; i++) arr2[i] = sc.nextInt();

        printArray(arr2);

        System.out.println(
            "Unique Elements : " + sol.removeDuplicates(arr2)
        );
        printArray(arr2);

        System.out.println();

        int[] array = arrayCreate(n, sc);

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
        System.out.println("Intersection : " + 
            sol.intersection(a1, a2));

        System.out.println();

        int num = sc.nextInt();
        int[] nums = arrayCreate(num - 1, sc);
        printArray(nums);
        System.out.println("Missing Number : " + 
            sol.missing_num_optimal(nums, num)
        );

        System.out.println();

        int one = sc.nextInt();
        int[] ones_array = arrayCreate(one, sc);
        printArray(ones_array);
        System.out.println("Max Consecutive Ones : " + 
            sol.max_consecutive_ones(ones_array) + "\n"
        );

        arr = arrayCreate(n, sc);
        printArray(arr);
        System.out.println("Number that appear only once : "
            + sol.appear_once(arr)
        );
        System.out.println();

        arr = arrayCreate(n, sc);
        int k = sc.nextInt();
        printArray(arr);
        System.out.println("Longest SubArray With Sum " + 
            k + " length : " + sol.longest_subArraySum(arr, k) + 
            "\n"
        );

        //printArray(sol.prefixSum(arr));

        arr = arrayCreate(n, sc);
        int sum = sc.nextInt();
        printArray(arr);
        int[] val = sol.twoSum_sorted(arr, sum);
        System.out.println("Indexes of required 2 Sums in Array : "
            + Arrays.toString(val) + "\n"
        );        

        arr = arrayCreate(n + 2, sc);
        printArray(arr);
        sol.sort_Array(arr);
        System.out.println("After Sorted : ");
        printArray(arr);
        System.out.println();

        arr = arrayCreate(n + 1, sc);
        printArray(arr);
        int majorityElement = sol.majority_element(arr);
        System.out.println("Majority Element : "
            + majorityElement + "\n"
        );

        arr = arrayCreate(n + 1, sc);
        printArray(arr);
        int max_subarraySum = sol.max_subarray_sum(arr);
        System.out.println("Maximum Subarray Sum : "
            + max_subarraySum + "\n"
        );

        arr = arrayCreate(n - 1, sc);
        printArray(arr,"Stock Prices");
        int maxProfit = sol.buySell_Stocks(arr);
        System.out.println(
            "Maximum Profit : " +
            maxProfit + '\n'
        );

        arr = arrayCreate(n+1, sc);
        printArray(arr);
        System.out.println("After Rearranged by Alternating Sign : ");
        sol.rearrange_by_sign(arr);
        printArray(arr,"New Array");
        System.out.println();

        arr = arrayCreate(4, sc);
        printArray(arr);
        System.out.println("All Permutations : ");
        var perms = extra.permutations(arr);
        for (ArrayList<Integer> arrList : perms) {
            System.out.println(arrList.toString());
        }
        System.out.println();

        arr = arrayCreate(n, sc);
        printArray(arr);
        sol.next_permutation(arr);
        printArray(arr,"Next Permutation");
        System.out.println();

        arr = arrayCreate(n-1, sc);
        printArray(arr);
        var leaders = sol.leaders(arr);
        System.out.println("Leaders : " + 
            leaders.toString() + "\n"
        );

        sc.close();
    }
}
