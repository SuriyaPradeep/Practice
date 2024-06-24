package SUMS;

public class SortColors {
    /*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
     */
    public void sortColors(int[] nums){
        int zeroPointer=0,twoPointer=nums.length-1,i=0;
        while(i<=twoPointer){
            int num=nums[i];
            if(num==2){
                swap(i,twoPointer--,nums);
                continue;
            }
            if(num==0){
                swap(i,zeroPointer++,nums);
            }
            i++;
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
