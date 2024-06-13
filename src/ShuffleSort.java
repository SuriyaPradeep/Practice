import java.util.Random;

public class ShuffleSort {
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void shuffle(int[] arr){
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            int j=random.nextInt(0,i+1);
            swap(i,j,arr);
        }
    }
    public static void sort(int[] arr){
        do {
            shuffle(arr);
        }while(!isSorted(arr));
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 88, 14, 20, 1, 0, 55};
        sort(arr);
        printArray(arr);
    }
}
