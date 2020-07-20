package me.xfly.leetcode;

public class LeetCode_1312 {

    public static void main(String[] args) {
        minInsertions("abv");
    }

    static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int span = 2; span <= n; ++span) {
            for (int i = 0; i <= n - span; ++i) {
                int j = i + span - 1;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
