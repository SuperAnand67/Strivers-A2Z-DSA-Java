import java.util.Scanner;

class Patterns{
    /** Rectangular Start Pattern
     * <p>
     * Time Complexity : O(n^2)<br>
     * Space Complexity : O(1)
     **/ 
    public void pattern1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Right Triangular Start Pattern
     * <p>
     * Time Complexity : O(n^2)<br>
     * Space Complexity : O(1)
     **/
    public void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Right-Angled Number Pyramid
     * <p>
     * Time Complexity : O(n^2)<br>
     * Space Complexity : O(1)
     **/
    public void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Right-Angled Number Pyramid - with same numbers in each row
     * <p>
     * Time Complexity : O(n^2)<br>
     * Space Complexity : O(1)
     **/
    public void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern5(int n){
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern6(int n){
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern7(int n){
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern8(int n){
        for(int i = 0;i < n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * (n - i) - 1 ; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
    }

    // It combines Pattern 7 and 8 to make a Diamond Shape Patterns
    public void pattern9Combination(int n) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i = 0;i < n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * (n - i) - 1 ; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
    }

}

public class Patterns_DSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patterns ptn = new Patterns();

        // int t = sc.nextInt();

        /*for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ptn.pattern1(n);
            System.out.println();
        }*/
        
        int n = sc.nextInt();

        ptn.pattern1(n);
        ptn.pattern2(n);
        ptn.pattern3(n);
        ptn.pattern4(n);
        ptn.pattern5(n);
        ptn.pattern6(n);
        ptn.pattern7(n);
        ptn.pattern8(n);
        ptn.pattern9(n);

        sc.close();
    }    
}
