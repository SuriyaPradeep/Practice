package SUMS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
     */
    public void backTrack(List<List<Integer>> ans,List<Integer>list,int[] candidates,int start,int target){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || start>=candidates.length){
            return;
        }else{
            list.add(candidates[start]);
            backTrack(ans,list,candidates,start,target-candidates[start]);
            list.remove(list.size()-1);
            backTrack(ans,list,candidates,start+1,target);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        backTrack(ans,list,candidates,0,target);
        return ans;
    }
}
