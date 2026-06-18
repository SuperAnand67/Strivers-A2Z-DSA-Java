import java.util.Scanner;

class HashingSoln{
    // HashMap Basics -> Precompute
    public int[] precompute(int[] arr){
        int n = arr.length;
        
        int[] hash = new int[10000000];

        for (int i : arr) {
            hash[arr[i]]++;
        }

        return hash;
    }
}

public class Hashing {

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void println(Object obj){
        System.out.println(obj);
    }

    public static void println(){
        System.out.println();
    }

    public static void print(Object obj){
        System.out.print(obj);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashingSoln hashS = new HashingSoln();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        print("Array : ");
        printArray(arr);
        println();

        // precompute
        int[] hash = hashS.precompute(arr);

        int q = sc.nextInt();

        while (q-- > 0) {
            int num = sc.nextInt();
            System.out.println("Frequency of " + num + " is " + 
                hash[num]);
        }
        
        sc.close();
    }
}
