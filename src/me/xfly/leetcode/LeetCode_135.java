package me.xfly.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode_135 {
    /**
     * 两个数组
     * 1.从左向右遍历，如果右边的值比左边的大，糖果加一
     * 2.从右向左遍历，如果左边的值比右边的大，糖果加以
     * 3.取每位最大值合并数组
     */
    public static int candyWith2Array(int[] ratings) {
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 1; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }

        return sum;
    }

    public static int candyWith1Array(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < result.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }

        int sum = result[result.length - 1];

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}
