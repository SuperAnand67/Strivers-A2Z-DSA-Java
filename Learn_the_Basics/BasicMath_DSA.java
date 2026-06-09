import java.util.Scanner;

class BasicMath{

    int power(int n,int exp){
        int result = 1;

        for (int i = 0; i < exp; i++)
            result *= n;

        return result;
    }

    // Time Complexity : O(log10 N + 1)
    int countDigits(int n){
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10; 
        }

        return count;
    }

    // Time Complexity : O(1)
    int countDigitsOptimal(int n){
        if(n == 0) return 1;

        int count = (int) Math.log10(Math.abs(n)) + 1;
        return count;
    }

    int reverseDigits(int n){
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

    boolean isPalindrome(int n){
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

    boolean isArmstrong(int n){

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
}

public class BasicMath_DSA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BasicMath bm = new BasicMath();

        int n = in.nextInt();

        System.out.println("N : " + n);

        System.out.println("No. of Digits : " + 
                bm.countDigitsOptimal(n));

        System.out.println("Reversed : " + bm.reverseDigits(n));
        
        System.out.println(bm.isPalindrome(n) ? 
                "Palindrome!" : "Not Palindrome !");

        System.out.println(bm.isArmstrong(n) ? 
                "Armstrong !" : "Not Armstrong !");

        in.close();
    }
}
