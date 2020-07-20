package me.xfly.leetcode;

import java.util.Arrays;

public class LeetCode_956 {

    public static void main(String[] args) {
        int[] rods = {1, 2, 3, 6};
        tallestBillboard(rods);
    }

    public static int tallestBillboard(int[] rods) {
        int s = 0;
        for (int i : rods) {
            s += i;
        }
        //公差为 i 时，最大公共高度
        int[] dp = new int[s+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int h : rods) {
            int[] current = dp.clone();
            for (int i = 0; i <= s - h; i++) {
                if (current[i] < 0 ) continue;

                // 原来有两个柱子，新的钢筋可以放在任意一个柱子上
                // 新的钢筋放在高的柱子上面
                // 新的公差 = i+h，
                // 公公高度取当前公共高度 current[i] 和 dp[i + h] 中比较大的那个
                dp[i + h] = Math.max(dp[i + h], current[i]);

                //新的钢筋放比较短的柱子上
                // 新的公差 ｜i - h｜
                //新的公共高度取 current[i]+Math.min(i,h) 和原有高度中高的那个
                int index = Math.abs(i-h);
                dp[index] = Math.max(dp[index],current[i]+Math.min(i,h));

                //其实还有一种情况，哪边都不放
                //原有公差、高度都没变 所以省略
                //dp[i] = current[i];
            }
        }
        return dp[0];
    }

}
