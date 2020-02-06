package me.xfly.leetcode;

public class Solution {
    public static void main(String[] args) {
        int[] coins = {5,2,1};
        System.out.println(coinChange(coins,11));
    }

    public  static int coinChange(int[] coins, int amount) {
        int i = coins.length-1;
        int result = 0;

        if (amount==0){
            return 0;
        }

        while (i >= 0 && amount > 0) {
            if (amount - coins[i] > 0) {
                amount = amount - coins[i];
                result++;
            }
            if (amount - coins[i] == 0) {
                return ++result;
            }
            if (amount-coins[i] < 0) {
                i--;
            }
        }


        return -1;
    }
}
