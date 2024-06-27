package SUMS;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Permutations {
    /*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]
     */
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void backtrack(List<List<Integer>>ans,int[] nums,int start){
        if(start==nums.length){
            List<Integer>list=new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(list);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(i,start,nums);
            backtrack(ans,nums,start+1);
            swap(i,start,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(ans,nums,0);
        return ans;
    }
}
