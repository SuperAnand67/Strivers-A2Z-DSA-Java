public class Practices {

    public static int majority(int[] arr){
        int n = arr.length;

        int count = 0;
        int ele = 0;

        for (int i = 0; i < n; i++) {
            if(count == 0){
                ele = arr[i];
                count++;
            }
            else if(arr[i] == ele) 
                count++;
            else
                count--;
        }

        return ele;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,4,2,2};

        System.out.println(majority(arr));
    }
    
}