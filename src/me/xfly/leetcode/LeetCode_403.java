package me.xfly.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode_403 {

    public static void main(String[] args) {
        int[] stones = {0,1,2,3,4,8,9,11};
        System.out.println(String.valueOf(canCross(stones)));
    }

    public static boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> memo = new HashMap<>();
        for (int stone : stones) {
            memo.put(stone, new HashSet<>());
        }

        memo.get(stones[0]).add(0);

        for (int i = 0; i < stones.length; i++) {
            for (int j : memo.get(stones[i])) {
                for (int k = j - 1; k <= j + 1; k++) {
                    if (k > 0 && memo.containsKey(stones[i] + k)) {
                        memo.get(stones[i] + k).add(k);
                    }
                }
            }
        }

        return memo.get(stones[stones.length - 1]).size() > 0;
    }
}
