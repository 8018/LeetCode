package me.xfly.leetcode;

import java.util.*;

public class LeetCode_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();

        for (int i = 1;i*i<=n;i++){
            squares.add(i*i);
        }
        Set<Integer> queue = new HashSet<>();

        int level = 0;

        queue.add(n);

        while (!queue.isEmpty()){
            Set<Integer> next_queue = new HashSet<>();
            level++;

            for (Integer current:queue){
                for (int square:squares){
                    int next = current - square;
                    if (next < 0){
                        break;
                    }

                    if (next == 0){
                        return level;
                    }


                    next_queue.add(next);
                }
                queue = next_queue;
            }
        }

        return n;
    }

}
