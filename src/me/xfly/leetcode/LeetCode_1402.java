package me.xfly.leetcode;

import java.util.Arrays;

public class LeetCode_1402 {
    public static void main(String[] args) {
        int[] satisfaction = {-2,5,-1,0,3,-3};
        System.out.println(maxSatisfaction(satisfaction));
    }

    //贪心算法
    //假设排序后数据为 s0 s1 s2 s3 ...... 从大到小排列
    // 如果前 n 项和大于0，可以继续向上累加
    public static  int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int ans = 0; int sum = 0;

        for (int i = satisfaction.length-1;i>=0;i--){
            sum += satisfaction[i];
            if (sum >0){
                ans+=sum;
            }
        }

        return ans;
    }
}