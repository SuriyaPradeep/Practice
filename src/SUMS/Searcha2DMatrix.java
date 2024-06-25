package SUMS;

public class Searcha2DMatrix {
    /*
You are given an m x n integer matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length,cols=matrix[0].length;
        int left=0,right=rows*cols-1;
        while(left<=right){
            int mid=(left+right)/2;
            int num=matrix[mid/cols][mid%cols];
            if(num==target){
                return true;
            }else if(num>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}
