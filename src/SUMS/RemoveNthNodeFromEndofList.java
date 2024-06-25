package SUMS;

public class RemoveNthNodeFromEndofList {
    /*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;
        ListNode slow1=head,slow2=head;
        for(int i=0;i<n;i++){
            slow1=slow1.next;
        }
        while(slow1.next!=null){
            slow1=slow1.next;
            slow2=slow2.next;
        }
        slow2.next=slow2.next.next;
        return head.next;
    }
}