import java.util.Arrays;

public class MergerSort {
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    public static void merge(int[] arr,int beg,int mid,int end){
        int n1=mid-beg+1;
        int n2=end-mid;
        int[] leftArray=Arrays.copyOfRange(arr,beg,mid+1);
        int[] rightArray=Arrays.copyOfRange(arr,mid+1,end+1);
        int left=0,right=0,k=beg;
        while(left<n1 && right<n2){
            if(leftArray[left]<=rightArray[right]){
                arr[k++]=leftArray[left++];
            }else{
                arr[k++]=rightArray[right++];
            }
        }
        while(left<n1){
            arr[k++]=leftArray[left++];
        }
        while(right<n2){
            arr[k++]=rightArray[right++];
        }
    }
    public static void mergeSort(int[] arr,int beg,int end){
        if(beg<end){
            int mid=(beg+end)/2;
            mergeSort(arr,beg,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 88, 14, 20, 1, 0, 55};
        sort(arr);
        System.out.println(isSorted(arr));
        printArray(arr);
    }
}
