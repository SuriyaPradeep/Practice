/*
A LinkedList in Java is a data structure that allows you to store elements in a sequential manner.
Unlike arrays, linked lists do not have a fixed size and can dynamically grow and shrink. A LinkedList consists of nodes,
where each node contains data and a reference (or link) to the next node in the sequence. There are several
types of linked lists, including singly linked lists, doubly linked lists, and circular linked lists.
 */
public class LinkedList {
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

    public LinkedList() {
        this.size = 0;
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean search(int target) {
        if (isEmpty()) {
            return false;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.val == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void insert(int val) {
        if (isEmpty()) {
            head = new Node(val);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
        }
        size++;
    }

    public void delete(int target) {
        if (isEmpty()) {
            return;
        }
        if (head.val == target) {
            head = head.next;
        } else {
            Node curr = head, prev = head;
            while (curr != null) {
                if (curr.val == target) {
                    prev.next = curr.next;
                    size--;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        size--;
    }

    public void traverse() {
        System.out.print("[ ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr=curr.next;
        }
        System.out.print("]");
        System.out.println();
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        System.out.println(list.search(5));
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        System.out.println(list.getSize());
        list.traverse();
        list.delete(1);
        list.delete(5);
        list.delete(2);
        System.out.println(list.getSize());
        list.traverse();
    }
}
