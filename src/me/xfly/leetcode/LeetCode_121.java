package me.xfly.leetcode;

public class LeetCode_121 {

    public static void main(String[] args) {
        int[] prices = { 7,6,4,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minValue = prices[0];

        for (int i = 0;i<prices.length;i++){
            int profit = prices[i] - minValue;
            maxProfit = Math.max(profit,maxProfit);
            minValue = Math.min(minValue,prices[i]);
        }

        return maxProfit;
    }
}
