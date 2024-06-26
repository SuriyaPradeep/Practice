package SUMS;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    /*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode>minHeap=new PriorityQueue<>((a,b)->(a.val- b.val));
        ListNode dummy=new ListNode(0),curr=dummy;
        for(ListNode node:lists){
            if(node!=null){
                minHeap.add(node);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            curr.next=node;
            curr=node;
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}
