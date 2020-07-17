package me.xfly.leetcode;

import java.util.Arrays;

import static java.lang.Math.abs;

public class LeetCode_1320 {

    public static void main(String[] args) {
        String word = "CAKE";
        System.out.println(minimumDistance(word.toUpperCase()));
    }

    static int distance(char x, char y) {
        int m = x - 'A';
        int n = y - 'A';
        int xdis = abs(m / 6 - n / 6);
        int ydis = abs((m % 6) - (n % 6));
        return xdis + ydis;
    }

    static int minimumDistance(String word) {
        int len = word.length();

        int[][] dp = new int[len][len];      // DP Array
        int[][] dist = new int[len][len];   // dist Array，用 tabular 空间换时间避免重复计算，

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dist[i][j] = distance(word.charAt(i), word.charAt(j));
            }
        }
        // 假设现在两个手指分别放在 i 字母处和 j 字母处
        // 新加入一个字母后 新的手指坐标可能为 (i+1,i) 和 （i+1,j）
        // (i+1,i) 原来的 j 处的手指移动到 i+1 移动距离为 dist[j][i+1]
        //（i+1,j） 原来 i 处的手指移动到 i+1 处 移动距离为 dist[i][i+1]
        for (int i = 1; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + dist[i-1][i]);

                dp[i][i-1] = Math.min(dp[i][i-1],dp[i-1][j]+ dist[j][i]);
            }

            // 原来用一根手指，第二根手指放新的字母上
            dp[i][i-1] = Math.min(dp[i][i-1], dp[i-1][i-1]);

            //依旧用一根手指，不放第二根
            dp[i][i] = dp[i-1][i-1] + dist[i-1][i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len-1; i++)
            ans = Math.min(ans, dp[len-1][i]);   // 无需考虑 d[len-1][len-1]，必然不是最优

        return ans;

    }

}
