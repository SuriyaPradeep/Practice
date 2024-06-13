import java.util.Random;
public class QuickSort {
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
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low,j=high+1;
        while(true){
            while(pivot>arr[++i]){
                if(i==high){
                    break;
                }
            }
            while(pivot<arr[--j]){
                if(j==low){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(i,j,arr);
        }
        swap(low,j,arr);
        return j;
    }
    public static void sort(int[] arr){
        shuffle(arr);
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int low,int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 88, 14, 20, 1, 0, 55};
        sort(arr);
        System.out.println(isSorted(arr));
        printArray(arr);
    }
}
