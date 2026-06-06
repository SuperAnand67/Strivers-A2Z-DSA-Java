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

    public void pattern5Variant(int n){
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
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

    public void pattern6Variant(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print((j+1) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern7(int n){
        for (int i = 0; i < n; i++) {
            // spaces
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern8(int n){
        for(int i = 0;i < n; i++){
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2 * (n - i) - 1 ; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
    }

    // It combines Pattern 7 and 8 to make a Diamond Shape Patterns
    public void pattern9(int n) {
        pattern7(n); // Upper Triangle
        pattern8(n); // Upside Down Triangle
    }

    // It combines Pattern 2 and 5 to make a Arrow like Shape
    //Either one of those patterns must n - 1 times
    public void pattern10(int n){
        pattern2(n - 1);
        pattern5(n);
    }

    public void pattern10Variant(int n){
        for (int i = 0; i < 2 * n - 1; i++) {
            int s = (i >= n) ? (2 * n - i - 1) : i+1;

            for (int j = 0; j < s; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern11(int n){
        for (int i = 0; i < n; i++) {
            int start = (i % 2 == 0) ? 1 : 0;

            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                //start = (start == 0) ? 1 : 0;
                start = 1 - start;
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void pattern12(int n){
        for (int i = 0; i < n; i++) {
            // nums
            for (int j = 0; j <= i; j++) {
                System.out.print(j+1);
            }

            // spaces
            for (int j = 0; j < 2 * n - 2 * (i + 1); j++) {
                System.out.print(" ");
            }

            // nums
            for (int j = i+1 ; j > 0; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
        System.out.println();
    }

    public void pattern13(int n){
        int c = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
                c++;
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
        System.out.println();
        ptn.pattern3(n);
        ptn.pattern4(n);
        ptn.pattern5Variant(n);
        ptn.pattern6Variant(n);
        ptn.pattern7(n);
        System.out.println();
        ptn.pattern8(n);
        ptn.pattern9(n);
        ptn.pattern10Variant(n);
        ptn.pattern11(n);
        ptn.pattern12(n);
        ptn.pattern13(n);

        sc.close();
    }    
}
