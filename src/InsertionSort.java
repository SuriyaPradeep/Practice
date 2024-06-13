public class InsertionSort {
    public static boolean isSorted(int[] arr){
        for(int i=1;i< arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(j,j-1,arr);
                }else{
                    break;
                }
            }
        }
    }
    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void printArray(int[] arr){
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr={5,1,10,88,14,20,1,0,55};
        sort(arr);
        System.out.println(isSorted(arr));
        printArray(arr);
    }
}
