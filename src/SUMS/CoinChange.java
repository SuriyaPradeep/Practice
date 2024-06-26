package SUMS;

import java.util.Arrays;

public class CoinChange {
    /*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] minCoins=new int[amount+1];
        Arrays.fill(minCoins,amount+1);
        minCoins[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    minCoins[i]=Math.min(minCoins[i],1+minCoins[i-coins[j]]);
                }
            }
        }
        return minCoins[amount]!=amount+1?minCoins[amount]:-1;
    }
}
