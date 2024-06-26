package SUMS;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

     */
    public int longestConsecutive(int[] nums){
        int max=0;
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            int left=num-1;
            int right=num+1;
            while(!set.isEmpty() && set.remove(left)){
                left--;
            }
            while(!set.isEmpty() && set.remove(right)){
                right++;
            }
            max=Math.max(max,right-left-1);
            if(set.isEmpty()){
                return max;
            }
        }
        return max;
    }
}
