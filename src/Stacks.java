/*
In Java, a stack is a data structure that follows the Last-In-First-Out (LIFO) principle.
This means that the last element added (pushed) to the stack is the first one to be removed (popped).
Stacks are useful in various applications such as evaluating expressions, backtracking algorithms, and managing function calls.
 */
public class Stacks {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    public Stacks() {
        this.size = 0;
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int val){
        Node newnode=new Node(val);
        newnode.next=head;
        head=newnode;
        size++;
    }
    public int pop(){
        Node curr=head;
        if(curr==null){
            return -1;
        }
        head=head.next;
        size--;
        return curr.val;
    }
    public int getSize(){
        return size;
    }
    public static void main(String[] args){
        Stacks stack=new Stacks();
        System.out.println(stack.getSize());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
    }
}
