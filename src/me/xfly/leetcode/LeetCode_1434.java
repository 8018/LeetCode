package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1434 {

    public static void main(String[] args) {
        List<List<Integer>> hats = new ArrayList<>();
        List<Integer> person1 = new ArrayList<>();

        person1.add(3);
        person1.add(5);
        person1.add(1);

        List<Integer> person2 = new ArrayList<>();
        person2.add(3);
        person2.add(5);

        hats.add(person1);
        hats.add(person2);

        System.out.println(numberWays(hats));
    }

    /**
     * 每增加一顶帽子，这顶帽子有两种分配情况
     * 1、不分配
     * 原来有几种分配情况还是几种，新的帽子不分配方案数不会减少
     * 2、戴在需要他但是原来没有得到的人的头上
     * */
    public static int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int N = 1000000007;

        int maxHats = 0;
        for (int i = 0; i < n; i++) {
            for (int h : hats.get(i)) {
                maxHats = Math.max(maxHats, h);  //找到帽子最大的索引，只需考虑此帽子之前的情况
            }
        }

        List<List<Integer>> htp = new ArrayList<>();
        for (int i = 0; i < maxHats; i++) {
            htp.add(new ArrayList<>());
        }
        //htp.get(j) 表示第j顶帽子被那些人喜欢
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < hats.get(i).size(); j++) {
                htp.get(hats.get(i).get(j) - 1).add(i); //吐了
            }
        }

        int[][] dp = new int[maxHats + 1][1 << n];
        //dp[i][j] 表示前i个人(分帽子状态为j)的情况下方案数
        //(j考虑为一个二进制数，第k位上的01表示第k个人有无分到帽子。j就是一个方案，总方案数为2^n即1<<n）

        dp[0][0] = 1; //回到dp[0][0]状态时为1个方案数！
        for (int i = 1; i <= maxHats; i++) {
            for (int j = 0; j < (1 << n); j++) {
                //1.第i个帽子不分配的情况
                dp[i][j] = dp[i - 1][j];
                //2.第i个帽子分给第k个人的情况

                //此时需要满足第k个人喜欢第i顶帽子,就是从喜欢第i顶帽子人的集合中找出这个人
                //判断第k个人在二进制方案j的第k个位数上是否为1,为1表示分配给这个人是一种方案，就可以加入这个方案

                for (int k : htp.get(i - 1)) {
                    //(j & (1 << k)) != 0 说明编号为 k 的 person 没有分配到帽子的方案数
                    //现在 k person 有了帽子，所以方案数增加
                    if ((j & (1 << k)) != 0) {
                        dp[i][j] += dp[i - 1][j - (1 << k)]; //状态转移 加上这个不同方案
                        // [j-(1<<k)] 表示将k这个人在方案j上的第k位的1去掉即前[i-1]个帽子不再分配给第k个人
                        // [j-(1<<k)] 写法等同于 [j^(1<<k)]
                        dp[i][j] %= N;
                    }
                }
            }
        }

        return dp[maxHats][(1 << n) - 1];

    }


}
