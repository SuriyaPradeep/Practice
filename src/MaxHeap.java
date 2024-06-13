public class MaxHeap {
    private int[] heap;
    private int size;
    public MaxHeap(){
        this.heap=new int[2];
        this.size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize(){
        return size;
    }
    private void resize(int capacity){
        int[] copyArray=new int[capacity];
        System.arraycopy(heap,1,copyArray,1,size);
        heap=copyArray;
    }
    private void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    private void swim(int k){
        while(k>1 && heap[k/2]<heap[k]){
            swap((k/2),k);
            k=(k/2);
        }
    }
    private void sink(int k){
        while(2*k<=size){
            int child=2*k;
            //int right=2*k+1;
            if(child<size && heap[child]<heap[child+1]){
                child++;//Change to right
            }
            if(heap[k]>heap[child]){
                break;
            }
            swap(k,child);
            k=child;
        }
    }
    public void add(int val){
        if(size==heap.length-1){
            resize(heap.length*2);
        }
        heap[++size]=val;
        swim(size);
    }
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int val=heap[1];
        swap(1,size--);
        sink(1);
        heap[size+1]=0;
        if(size<(heap.length-1)/4){
            resize(heap.length/2);
        }
        return val;
    }
    public int max(){
        return heap[1];
    }
    public static void main(String[] args){
        MaxHeap maxHeap=new MaxHeap();
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(25);
        maxHeap.add(11);
        maxHeap.add(13);
        System.out.println(maxHeap.max());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
    }
}
