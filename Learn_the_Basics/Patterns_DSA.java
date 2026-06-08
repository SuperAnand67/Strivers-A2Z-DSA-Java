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
        //System.out.println();
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
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((num++) + " ");
                // num++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern14(int n){
        // Stops this if n is greater than the alphabets count
        if (n > 26) return;

        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern15(int n){
        if (n > 26) return;

        for (int i = n; i > 0; i--) {
            char alphabet = 'A';
            for (int j = 0; j < i; j++) {
                System.out.print(alphabet++ + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern16(int n){
        char alphabet = 'A';

        if (n > 26) return;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(alphabet + " ");
            }
            alphabet++;
            System.out.println();
        }
        System.out.println();
    }

    public void pattern17(int n){
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // characters
            char ch = 'A';
            int flip = (2 * i + 1) / 2;

            // Here, flip * 2 + 1 gives sames ans as 2 * i + 1
            for (int j = 0; j < flip * 2 + 1; j++) {
                System.out.print((j < flip) ? ch++ : ch--);
            }

            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern17MyVariant(int n){
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // characters

            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch);
            }

            char c = (char) ('A' + i - 1);
            
            for (char ch = c; ch >= 'A'; ch--) {
                System.out.print(ch);
            }

            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern18(int n){
        for (int i = 0; i < n; i++) {

            char c = (char) ('A' + (n - 1) - i);

            for (char ch = c; ch < 'A' + n; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern19Top(int n){
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern19Bottom(int n){
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < 2 * n - 2 * (i + 1); j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void pattern19(int n){
        char ch = '*';
        for (int i = 0; i < 2 * n; i++) {

            // Top Part
            if (i < n) {
                // stars
                for (int j = 0; j < n - i; j++) {
                    System.out.print(ch);
                }

                // spaces
                for (int j = 0; j < 2 * i; j++) {
                    System.out.print(" ");
                }

                // stars
                for (int j = 0; j < n - i; j++) {
                    System.out.print(ch);
                }

                System.out.println();
            }
            // Bottom Part
            else {
                // stars
                for (int j = 0; j < (i + 1) - n; j++) {
                    System.out.print(ch);
                }

                // spaces
                int sp = 2 * n - 2 * ((i - n) + 1);
                for (int j = 0; j < sp; j++) {
                    System.out.print(" ");
                }


                // stars
                for (int j = 0; j < (i + 1) - n; j++) {
                    System.out.print(ch);
                }
                System.out.println();
                
            }    
        }
        System.out.println();
    }

    public void pattern19MyVariant(int n){
        pattern19Top(n);
        pattern19Bottom(n);
        System.out.println();
    }

    public void pattern20(int n){
        
        for (int i = 0; i < 2 * n - 1; i++) {
            int s = (i >= n) ? (2 * n - i - 1) : i + 1;

            // stars
            for (int j = 0; j < s; j++) {
                System.out.print("*");
            }

            // spaces
            int sp = (i < n) ? 2 * (n - i - 1) : 2* (i - n + 1);
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < s; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void pattern21MyVariant(int n){
        for (int i = 0; i < n; i++) {
            int stars = ((i == 0) || (i == n-1)) ? n : 1;
            
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }

            for (int j = 0; j < n - 2; j++) {
                System.out.print("  ");
            }

            System.out.print((stars == n) ? "" : "* ");

            System.out.println();
        }
    }

    // Hollow Square
    public void pattern21(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i == 0 || j == 0 ||
                                 i == n-1 || j == n-1) ? 
                                "* " : "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern22(int n){
        int s = 2 * n - 1;

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                int top = i;
                int left = j;
                int bottom = (2 * n - 2) - i;
                int right = (2 * n - 2) - j;

                int num = Math.min(
                    Math.min(top, bottom), 
                    Math.min(right,left));

                System.out.print((n - num) + " ");
            }
            System.out.println();
        }
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
        System.out.println();
        ptn.pattern11(n);
        ptn.pattern12(n);
        ptn.pattern13(n);
        ptn.pattern14(n);
        ptn.pattern15(n);
        ptn.pattern16(n);
        ptn.pattern17(n);
        ptn.pattern18(n);
        ptn.pattern19MyVariant(n);
        ptn.pattern20(n);
        ptn.pattern21(n);
        ptn.pattern22(n-1);

        sc.close();
    }    
}
