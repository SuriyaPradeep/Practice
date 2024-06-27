package SUMS;

import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop {
    /*
You are given an integer array prices where prices[i] is the price of the ith item in a shop.
There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.

Example 1:
Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
     */
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int ans[]=new int[n];
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            int num=prices[i];
            while(!stack.isEmpty() && num<=prices[stack.peek()]){
                ans[stack.pop()]=num;
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            prices[i]-=ans[i];
        }
        return prices;
    }
}
