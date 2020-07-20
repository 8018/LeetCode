package me.xfly.leetcode;

public class LeetCode_1000 {
    private static final int INF = 0x3f3f3f3f;
    private int K;
    int[][][] memo;
    int[] preSum;

    public static void main(String[] args) {
        LeetCode_1000 leetCode_1000 = new LeetCode_1000();
        int[] stones = {3, 5, 1, 2, 6};
        System.out.println(leetCode_1000.mergeStones(stones, 3));
    }

    /**
     * 动态规划
     * 定义状态: f[i][j][k] 表示将 [i, j] 区间的石头缩小成 k 堆的最小体力花费
     * 合法状态: j-i+1 >= k
     * 最终答案: f[0][n-1][1]
     * 状态转移: 想要把 [i, j] 区间的合并成 1 堆, 那么它的上一个状态一定是 K 堆
     *          f[i][j][1] = f[i][j][K] + sum(i, j)
     *          而对于非 1 的情况, 即 f[i][j][k], 我们需要考虑从 i 开始的多长的区间最终合并成 1 堆
     *          f[i][j][k] = min{ f[i][j'][1] + f[j'+1][j][k-1] }
     */
    int mergeStones(int[] stones, int K) {
        this.K = K;

        preSum = new int[stones.length];

        preSum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            preSum[i] = preSum[i - 1] + stones[i];
        }
        memo = new int[stones.length][stones.length][K + 1];

        int res = memoSearch(0, stones.length - 1, 1);
        return res < INF ? res : -1;
    }

    int memoSearch(int i, int j, int k) {
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }

        if (j - i + 1 == k) {
            return 0;
        } else if (j - i + 1 < k) {
            return INF;
        }
        if (k == 1) {
            memo[i][j][k] = memoSearch(i, j, K) + sum(i, j);
            return memo[i][j][k];
        }

        memo[i][j][k] = INF;

        for (int m = i; m < j;m++){
            memo[i][j][k] = Math.min(memo[i][j][k],memoSearch(i,m,1)+memoSearch(m+1,j,k-1));
        }
        return memo[i][j][k];
    }

    int sum(int i, int j) {
        return preSum[j] - preSum[i];
    }


}
