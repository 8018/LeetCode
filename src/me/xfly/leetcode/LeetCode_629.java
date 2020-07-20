package me.xfly.leetcode;

public class LeetCode_629 {

    public static void main(String[] args) {
        kInversePairs(10,3);
    }

    public static int kInversePairs(int n, int k) {
        int mod = (int) (1e9 + 7);
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // 最大逆序数
            int cnt = i * (i - 1) >> 1;
            for (int j = 1; j <= Math.min(cnt, k); j++) {
                // j >= i ? f[i - 1][j - i] : 0
                // 这个是因为 f[i - 1][j] 已经囊括了j以前的了，不需要重复计算，只要计算后面的
                f[i][j] = (f[i][j - 1] % mod + (f[i - 1][j] - (j >= i ? f[i - 1][j - i] : 0) + mod) % mod) % mod;
            }
        }
        return f[n][k];

    }

}
