public class HeapSort {
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
    public static void sink(int k,int n,int[] arr){
        while(2*k+1<n){
            int child=2*k+1;
            if(child<n-1 && arr[child]<arr[child+1]){
                child++;
            }
            if(arr[k]>=arr[child]){
                break;
            }
            swap(k,child,arr);
            k=child;
        }
    }
    public static void sort(int[] arr){
        //heapify
        int n= arr.length;
        for(int k=n/2-1;k>=0;k--){
            sink(k,n,arr);
        }
        for(int k=n-1;k>=0;k--){
            swap(0,k,arr);
            sink(0,k,arr);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 88, 14, 20, 1, 0, 55};
        sort(arr);
        System.out.println(isSorted(arr));
        printArray(arr);
    }
}
