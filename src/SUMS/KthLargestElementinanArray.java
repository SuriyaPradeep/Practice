package SUMS;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray {
    /*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            maxHeap.add(num);
        }
        for(int i=1;i<k;i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
