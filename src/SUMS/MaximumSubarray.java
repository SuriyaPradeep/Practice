package SUMS;

public class MaximumSubarray {
    /*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
     */
    public int maxSubArray(int[] nums){
        int maxSum=Integer.MIN_VALUE,currSum=0;
        for(int num:nums){
            currSum+=num;
            maxSum=Math.max(maxSum,currSum);
            currSum=Math.max(currSum,0);
        }
        return maxSum;
    }
}
