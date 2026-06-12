import java.util.Scanner;

// TC -> Time Complexity
// SC -> Space Complexity

class Solutions{

    public void print(Object obj){
        System.out.println(obj);
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

}

public class Recursion {
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
        System.out.println();

        soln.printTo1_BackTrack(1, n);

        System.out.printf("\nSum of First %d Natural Numbers : ",n);
        System.out.println(soln.SumOfN(n));

        soln.SumOfN_Variant(n, 0);

        sc.close();
    }
}
