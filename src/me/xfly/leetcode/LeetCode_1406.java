package me.xfly.leetcode;

import java.util.Arrays;

public class LeetCode_1406 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,7};
        stoneGameIII(nums);
    }

    /**
     * 典型的零和博弈
     * 要从后往前算
     * f[i] 为 [i-n] 项先手的赢的分数
     * f(i) = max(sum(i,j−1)−f[j]),j∈[i+1,i+3]
     * */
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        // 边界情况，当没有石子时，分数为 0
        f[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            int pre = 0;
            for (int j = i + 1; j <= i + 3 && j <= n; ++j) {
                pre += stoneValue[j - 1];
                f[i] = Math.max(f[i], pre - f[j]);
            }
        }
        if (f[0] == 0) {
            return "Tie";
        } else {
            return f[0] > 0 ? "Alice" : "Bob";
        }
    }

}
