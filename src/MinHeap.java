public class MinHeap {
    private int[] heap;
    private  int size;
    public MinHeap(){
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
    private  void swim(int k){
        while(k>1 && heap[k]<heap[k/2]){
            swap((k/2),k);
            k=k/2;
        }
    }
    private void sink(int k){
        while(2*k<=size){
            int child=2*k;
            if(child<size && heap[child]>heap[child+1]){
                child++;
            }
            if(heap[k]<heap[child]){
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
    public int min(){
        return heap[1];
    }
    public static void main(String[] args){
        MinHeap minHeap=new MinHeap();
        minHeap.add(50);
        minHeap.add(70);
        minHeap.add(1);
        minHeap.add(10);
        minHeap.add(5);
        System.out.println(minHeap.min());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.getSize());
        System.out.println(minHeap.remove());
    }
}
