package SUMS;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElements {
    /*
Problem Statement: Given an array arr of integers, for each element, find the nearest smaller element on the left side. If no such element exists, return -1 for that element.
Input: An array of integers arr.
Output: An array of integers representing the nearest smaller elements.
Test Case
Input: arr = [4, 5, 2, 10, 8]
Output: [-1, 4, -1, 2, 2]
Explanation: For 4, no smaller element exists on the left side, so the result is -1. For 5, the nearest smaller element on the left side is 4. For 2, no smaller element exists on the left side, so the result is -1. For 10, the nearest smaller element on the left side is 2. For 8, the nearest smaller element on the left side is 2.
     */
    public static int[] nearestSmallerElements(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            int num=arr[i];
            while(!stack.isEmpty() && stack.peek()>=num){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i]=stack.peek();
            }
            stack.push(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={4,5,2,10,8};
        int[] ans=nearestSmallerElements(arr);
        System.out.print("[ ");
        for(int n:ans){
            System.out.print(n+" ");
        }
        System.out.print("]");
    }
}
