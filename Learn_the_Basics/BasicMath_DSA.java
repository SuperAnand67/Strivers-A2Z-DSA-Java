import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BasicMath{

    public int power(int n,int exp){
        int result = 1;

        for (int i = 0; i < exp; i++)
            result *= n;

        return result;
    }

    // Time Complexity : O(log10 N + 1)
    public int countDigits(int n){
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10; 
        }

        return count;
    }

    // Time Complexity : O(1)
    public int countDigitsOptimal(int n){
        if(n == 0) return 1;

        int count = (int) Math.log10(Math.abs(n)) + 1;
        return count;
    }

    public int reverseDigits(int n){
        /* int f = 0;
        if (n < 0){
            n = Math.abs(n);
            f = 1;
        } */
        long rev = 0; 

        while (n != 0) {
            int d = n % 10;
            rev = rev * 10 + d;
            n /= 10;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            return 0;

        return (int) rev;
    }

    public boolean isPalindrome(int n){
        if (n < 0) return false;

        int x = n;
        int rev = 0;

        while (n > 0) {
            int d = n % 10;
            rev = rev * 10 + d;
            n /= 10;
        }

        return (rev == x);
    }

    public boolean isArmstrong(int n){

        if (n == 0) return true;
        if (n < 0) return false;

        int c = (int) Math.log10(n) + 1;
        int res = 0;
        int x = n;

        while (n > 0) {
            int d = n % 10;
            res = res + power(d, c);
            n = n / 10;
        }

        return (res == x);
    }
    
    // Time Complexity : O(n)
    public void printDivisors(int n){

        System.out.print("Divisors of " + n + " :");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(" " + i + ",");
            }
        }
        System.out.print(" " + n);
    }

    // Time Complexity : O()
    public void printDivisorsOptimal(int n){
        List<Integer> factors = new ArrayList<>(); 

        for (int i = 1; i * i <= n; i++) {  // or we can check
                                            // for n <= sqrt(n)
            if (n % i == 0) {
                factors.add(i);

                if (n / i != i)
                    factors.add(n/i);
            }
                  
        }

        Collections.sort(factors);
        
        System.out.print("Divisors of " + n + " : ");
        System.out.println(factors.toString());

        /* for (Integer i : factors) {
            System.out.print(i + ", ");
        } */
    }

    public boolean isPrime(int n){

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    // Brute Force Approach
    // Time Complexity : O(min(n1,n2))
    public int getGCD(int n1,int n2){
        int min = (n1 >= n1) ? n2 : n1;
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (n1 % i == 0 && n2 % i == 0) 
                gcd = i;
        }

        return gcd;
    }

    public int getGCDbetter(int n1,int n2){
        int min = (n2 >= n1) ? n1 : n2;
        if (n1 == 0 || n2 == 0) return Math.abs(n2 - n1);
        int gcd = 1;
        
        for (int i = min; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
                break;
            }
        }

        return gcd;
    }

    // Use Euclidian Distance Algorithm
    // Time Complexity : O(log(min(a,b)))
    public int getGCD_Euclidean(int a,int b){
        
        while (a > 0 && b > 0) {
            if (a < b) {
                b = b % a;
            }
            else{
                a = a % b;
            }
        }

        return Math.abs(a - b);
    }

    public void Getgcd(int n1,int n2){

        if(n1 <= 0) {
            System.out.println(n2);
            return;
        } 
        if(n2 <= 0){
            System.out.println(n1);
            return;
        }
        if (n1 > n2)
            n1 = n1 % n2;
        else
            n2 = n2 % n1;

        Getgcd(n1, n2);
        
    }

}

public class BasicMath_DSA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BasicMath bm = new BasicMath();

        int n = in.nextInt();
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        System.out.println("N : " + n);

        System.out.println("No. of Digits : " + 
                bm.countDigitsOptimal(n));

        System.out.println("Reversed : " + bm.reverseDigits(n));
        
        System.out.println(bm.isPalindrome(n) ? 
                "Palindrome!" : "Not Palindrome !");

        System.out.println(bm.isArmstrong(n) ? 
                "Armstrong !" : "Not Armstrong !");

        bm.printDivisorsOptimal(n);

        System.out.println(bm.isPrime(n) ? 
                "Prime !" : "Not a Prime !");

        System.out.printf("GCD of (%d,%d) : %d\n",
                n1,n2,bm.getGCD_Euclidean(n1, n2));

        System.out.printf("GCD of (%d,%d) : ",n1,n2);
        bm.Getgcd(n1, n2);

        in.close();
    }
}
