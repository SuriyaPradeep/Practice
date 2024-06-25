package SUMS;

import java.util.*;

public class ThreeSum {
    /*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>set=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<=n-3 && nums[i]<=0;i++){
            if(i>0 &&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1,right=n-1;
            while(left<right){
                int num=nums[i]+nums[left]+nums[right];
                if(num==0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }else if(num>0){
                    right--;
                    while(right>left && nums[right]==nums[right+1]){
                        right--;
                    }
                }else{
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
