/*
In Java, a queue is a data structure that follows the First-In-First-Out (FIFO) principle.
This means that the first element added to the queue is the first one to be removed.
Queues are used in various scenarios such as task scheduling, managing requests in web servers, and breadth-first search algorithms in graphs.

 */
public class Queues {
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

    public Queues() {
        this.size = 0;
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int val) {
        if (isEmpty()) {
            head = new Node(val);
        } else {
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next = new Node(val);
        }
        size++;
    }

    public int dequeue() {
        Node curr = head;
        if (curr == null) {
            return -1;
        }
        head = head.next;
        size--;
        return curr.val;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Queues queues = new Queues();
        queues.enqueue(1);
        queues.enqueue(2);
        queues.enqueue(3);
        queues.enqueue(4);
        System.out.println(queues.dequeue());
        System.out.println(queues.dequeue());
    }
}
