package SUMS;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0),node=dummy;
        while(list1!=null && list2!=null){
            int val1=list1.val;
            int val2=list2.val;
            ListNode curr;
            if(val1<=val2){
                curr=new ListNode(val1);
                list1=list1.next;
            }else{
                curr=new ListNode(val2);
                list2=list2.next;
            }
            node.next=curr;
            node=node.next;
        }
        while(list1!=null){
            node.next=new ListNode(list1.val);
            node=node.next;
            list1=list1.next;
        }
        while(list2!=null) {
            node.next=new ListNode(list2.val);
            node=node.next;
            list2=list2.next;
        }
        return dummy.next;
    }
}
