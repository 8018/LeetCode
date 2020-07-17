package me.xfly.leetcode;

import java.util.Arrays;

import static java.lang.Math.abs;

public class LeetCode_1320 {

    public static void main(String[] args) {
        String word = "CAKE";
        System.out.println(minimumDistance(word.toUpperCase()));
    }

    static int distance(char x, char y){
        int m = x - 'A';
        int n = y - 'A';
        int xdis = abs(m/6-n/6);
        int ydis = abs((m%6)-(n%6));
        return xdis + ydis;
    }

    static int minimumDistance(String word) {
        int len = word.length();

        int[][] d = new int[len][len];      // DP Array
        int[][] dist = new int[len][len];   // dist Array，用 tabular 空间换时间避免重复计算，
        // 但此步意义也不明显，因为重复计算并不频繁，可省略
        for (int i = 0; i < len; i++)
            for (int j = i+1; j < len; j++)
                dist[i][j] = distance(word.charAt(i), word.charAt(j));

        for (int i = 1; i < len; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);   // 初始化

            for (int j = 0; j < i-1; j++) {
                // 将原先放在第 i-1 个字母上的手指移到 i 上，此时两根手指分别以第 i, j 个字母为终点
                d[i][j] = Math.min(d[i][j], d[i-1][j] + dist[i-1][i]);
                // 将原先放在第 j 个字母上的手指移到 i 上，此时两根手指分别以第 i, i-1 个字母为终点
                d[i][i-1] = Math.min(d[i][i-1], d[i-1][j] + dist[j][i]);
            }

            // 如果此前仅使用了一根手指，可以将第二根手指放在第 i 个字母上，不消耗步数；可以将消耗理解为 `d[i-1][i-1] + 0`
            d[i][i-1] = Math.min(d[i][i-1], d[i-1][i-1]);
            // 依旧仅使用一根手指
            d[i][i] = d[i-1][i-1] + dist[i-1][i];
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len-1; i++)
            ret = Math.min(ret, d[len-1][i]);   // 无需考虑 d[len-1][len-1]，必然不是最优

        return ret;

    }

}
