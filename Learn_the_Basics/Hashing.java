import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashingSoln {
    // HashMap Basics -> Precompute - Number Hashing
    public int[] precompute(int[] arr) {
        int[] hash = new int[10000000];

        for (int i : arr) {
            hash[arr[i]]++;
        }

        return hash;
    }

    // Precompute - Character Hasing
    // Ascii Values
    // 0 - 48
    // 'A' - 65
    // 'a' - 97
    public int[] precomputeChar(String str) {
        int[] hash = new int[256];

        for (char c : str.toCharArray()) {
            hash[c]++;
        }

        return hash;
    }

    public HashMap precomputeOptimal(int[] arr){
        HashMap<Integer, Integer> table = new HashMap<>();

        for(int i : arr){
            int freq = 0;

            if (table.containsKey(i)) freq = table.get(i);
            freq++;
            table.put(i, freq);
        }

        return table;
    }

    // public char[] highLowFrequency(String s){
    //     if (s == null || s.length() <= 1) {
    //     return s == null ? new char[0] : s.toCharArray();
    // }

    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char high = '0';
    //     char low = '0';

    //     for (char c : s.toCharArray()) {
    //         int freq = map.containsKey(c) ? map.get(c) : 0;
    //         map.put(c, ++freq);

    //         high = map.get(c) > map.get(high) ? c : high;
    //         low = map.get(c) < map.get(low) ? c : low;
    //     }
        
    //     return new char[]{high,low};
    // }
}

public class Hashing {

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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

        // precompute
        int[] hash = hashS.precompute(arr);

        int q = sc.nextInt();

        println("Number\tFrequency");
        while (q-- > 0) {
            int num = sc.nextInt();
            println(num + "\t\t " + hash[num]);
        }

        println();

        String str = sc.next();
        println("String : " + str);

        int[] hashC = hashS.precomputeChar(str);

        int r = sc.nextInt();

        println("Character\tFrequency");
        while (r-- > 0) {
            char ch = sc.next().charAt(0);
            println(ch + "\t\t    " + hashC[ch]);
            //println("Frequency of " + ch + " is " + hashC[ch]);
        }
        println();

        int[] a = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        println("Using HashMap");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            int freq = map.containsKey(a[i]) ? 
                map.get(a[i]) : 0;

            map.put(a[i], ++freq);
        }
        
        // precompute
        //HashMap<Integer, Integer> map2 = hashS.precomputeOptimal(arr);

        // for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        //     println(e.getKey() + " --> " + e.getValue());
        // }

        int s = sc.nextInt();

        print("Array : ");
        printArray(a);
        println("Number\tFrequency");
        while (s-- > 0) {
            int num = sc.nextInt();
            int freq = map.getOrDefault(num,0);

            println(num + "\t\t " + freq);

        }

        println();

        String st = sc.next();
        println("String : " + st);

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char ch : st.toCharArray()) {
            int freq = charMap.containsKey(ch) ? 
                charMap.get(ch) : 0;

            charMap.put(ch, ++freq);
        }

        int v = sc.nextInt();
        println("Character\tFrequency");
        while (v-- > 0) {
            char ch = sc.next().charAt(0);
            println(ch + "\t\t    " + charMap.getOrDefault(ch,0));
        }
        println();

        //char[] freq = hashS.highLowFrequency(st);

        //println("Highest Frequency : " + freq[0]);
        //println("Lowest Frequency : " + freq[1]);

        sc.close();
    }
}
