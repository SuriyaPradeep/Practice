package SUMS;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver=0;
        ListNode dummy=new ListNode(0),curr=dummy;
        while(l1!=null || l2!=null || carryOver!=0){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            int sum=val1+val2+carryOver;
            carryOver=sum/10;
            sum=sum%10;
            curr.next=new ListNode(sum);
            curr=curr.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        return dummy.next;
    }
}
