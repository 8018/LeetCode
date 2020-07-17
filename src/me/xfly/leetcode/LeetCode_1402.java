package me.xfly.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_1402 {
    public static void main(String[] args) {
        int[] satisfaction = {-2,5,-1,0,3,-3};
        System.out.println(maxSatisfaction(satisfaction));
    }

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