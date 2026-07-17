import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// TC -> Time Complexity
// SC -> Space Complexity

class Solutions{

    // Simple Print Function
    public void print(Object obj){
        System.out.println(obj);
    }

    // A Swap function
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int r = 0;

    // Recursion without Base Case
    public void print(){
        System.out.println(1);
        print();        // Runs Forever or Until Stack Overflow
    }

    // Recursion with Base Case
    // Print numbers upto n-1
    public void printS(int n){

        if (r == n) return;         // Base Case

        System.out.println(r);
        r++;
        printS(n);
    }

    // Print the name - n times
    // TC : O(n)
    // SC : O(n)
    public void printName(String name,int n){
        if(n == 0) {
            System.out.println();
            return;
        }

        System.out.print(name + " ");
        printName(name,n-1);
    }

    // Prints from 1 to n
    // TC : O(n)
    // SC : O(n)
    public void printToN(int i,int n){
        if(i > n){
            System.out.println();
            return;
        }

        System.out.print(i + " ");
        printToN(i+1, n);
    }

    // Prints from n to 1
    // TC : O(n)
    // SC : O(n)
    public void printTo1(int n){
        if (n == 0){
            System.out.println();
            return;
        }

        System.out.print(n + " ");
        printTo1(n-1);
    }

    // Prints from 1 to n (but By Backtracking)
    // TC : O(n)
    // SC : O(n)
    public void printToN_Backtrack(int n){
        if(n == 0)
            return;

        printToN_Backtrack(n - 1);
        System.out.print(n + " ");
    }

    public void printTo1_BackTrack(int i,int n){
        if (i > n)
            return;

        printTo1_BackTrack(i+1, n);
        System.out.print(i + " ");
    }

    public int SumOfN(int i,int n){
        if (i == n)
            return n;

        return i + SumOfN(i + 1,n);
    }

    public int SumOfN(int n){
        if (n < 1)
            return n;

        return n + SumOfN(n-1);
    }

    public void SumOfN_Variant(int i,int sum){
        if (i < 1) {
            print(sum);
            return;
        } 

        SumOfN_Variant(i - 1,sum + i);
        
    }

    public int fact(int n){
        if(n == 0) return 1;

        return n * fact(n - 1);
    }

    public int[] reverseArray(int[] a,int left,int right){
        if (left >= right) return a;

        swap(a, left, right);

        return reverseArray(a, left + 1, right - 1);
    }

    // with one pointer instead of 2
    public int[] revArrayVariant(int[] a,int i){
        int n = a.length;

        if (i == n-i-1) return a;

        swap(a, i, n-i-1);

        return revArrayVariant(a, i+1);
    }

    public boolean IsPaliArray(int[] a,int i){
        int n = a.length;
        if (a[i] != a[n-i-1]) return false;
        if (i >= n/2) return true;

        return IsPaliArray(a, i+1);
    }

    public boolean IsPalindrome(String str){
        if(str == null || str.isEmpty()) return false;

        String s = str.toLowerCase().
            replaceAll("[^a-zA-Z0-9]","");

        return IsPalindrome(s,0);
    }
    
    public boolean IsPalindrome(String str,int i){
        int n = str.length();
        
        if(i >= n/2) return true;
        if(str.charAt(i) != str.charAt(n-i-1)) return false;

        return IsPalindrome(str, i+1);
    }

    public int fibonacci(int n){

        if (n <= 1)
            return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public void recursion_permutate(
        boolean[] map,List<Integer> perm,
        ArrayList<ArrayList<Integer>> ans,int[] arr){
            int n = arr.length;
            if (perm.size() == n) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!map[i]) {
                    map[i] = true;
                    perm.add(arr[i]);
                    recursion_permutate(map, perm, ans, arr);
                    perm.remove(perm.size() - 1);
                    map[i] = false;
                }
            }
            
        }

    public ArrayList<ArrayList<Integer>> permutations(int[] arr){
        int n = arr.length;
        boolean[] map = new boolean[n];
        var perm = new ArrayList<Integer>();
        var ans = new ArrayList<ArrayList<Integer>>();
        recursion_permutate(map, perm, ans, arr);
        return ans;
    }

}

public class Recursion {

    public static void print(Object obj){
        System.out.println(obj);
    }

    public static void print(){
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solutions soln = new Solutions();

        int n = sc.nextInt();
        String name = sc.next();

        //soln.print();
        soln.printS(n);
        
        soln.printName(name, n);

        soln.printToN(1, n);

        soln.printTo1(n);

        soln.printToN_Backtrack(n);
        print();

        soln.printTo1_BackTrack(1, n);

        System.out.printf(
            "\nSum of First %d Natural Numbers : ",n);
        System.out.println(soln.SumOfN(n));

        soln.SumOfN_Variant(n, 0);

        System.out.printf("factorial of %d is %d\n",
            n,soln.fact(n));

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        print("Original Array : "+ Arrays.toString(arr));

        //int[] rev = soln.reverseArray(arr, 0, n-1);
        int[] reverse = soln.revArrayVariant(arr, 0);
        
        print("Reversed Array : "+ Arrays.toString(reverse));

        String Ispal = soln.IsPaliArray(arr, 0) ? 
            "Palindrome":"Not Palindrome";

        print(Ispal);

        String str = sc.next();

        String IsPalindrome = soln.IsPalindrome(str) ? 
            "Palindrome" : "Not Palindrome";

        print(str + " is " + IsPalindrome);

        print(soln.fibonacci(n));

        sc.close();
    }
}
