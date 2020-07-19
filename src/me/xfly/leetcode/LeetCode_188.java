package me.xfly.leetcode;

public class LeetCode_188 {
    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(maxProfit(2, prices));

    }

    public static int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        // 超过交易上限，变成无限次交易问题
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }

        //定义状态
        int[][] dp = new int[k][2];

        //
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        for (int p : prices) {
            dp[0][0] = Math.max(dp[0][0], 0 - p);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);

            for (int i = 1; i < k; i++) {
                //第 i 次买入
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - p);
                //第 i 次卖出
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);
            }
        }
        return dp[k - 1][1];
    }

    // 解决无限次交易的方法
    public static int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
