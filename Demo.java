import java.util.Scanner;

class Solutions{
    public int findLength(String s) {
        return s.length();
    }

    public void accessChars(String s) {
        for (int i = 0; i < s.length(); i++)
            System.out.printf("Index %d : %c\n",i,s.charAt(i));
    }

    public String modifyString(String s) {
        String str = s;

        str += " - Outlier";

        return str;
    }

    public boolean compareString(String s1,String s2) {
        return s1.equals(s2);
    }

    public void factorial(int n) {
        int num = n;
        int fact = 1;
        while (n > 0) {
            fact *= n;
            n--;
        }

        System.out.printf("The Factorial of %d is %d",num,fact);
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("HelloWorld!");
        Scanner sc = new Scanner(System.in);

        Solutions soln =  new Solutions();

        int num = sc.nextInt();
        String str = sc.next();
        int n = sc.nextInt();

        System.out.println("Your Number is " + num);

        System.out.println("the length of " + str + " is " + soln.findLength(str));
        soln.accessChars(str);

        System.out.printf("Original String : %s\nModified : %s\n",str,soln.modifyString(str));

        System.out.println(soln.compareString(str, soln.modifyString(str)) ? "Equal !" : "Not Equal !");

        soln.factorial(n);
        
        sc.close();
    }
}
