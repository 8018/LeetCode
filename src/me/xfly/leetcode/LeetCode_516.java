package me.xfly.leetcode;

public class LeetCode_516 {
    public static void main(String[] args) {
        String test =  "aaba";
        System.out.println(longestPalindromeSubseq(test));
    }

    /*public static int longestPalindromeSubseq(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        int longest = 1;

        for (int i = 1; i < 2 * n - 1; i++) {
            int left, right;
            if (i % 2 == 0) {
                left = i - 1;
                right = i + 1;
            } else {
                left = i - 2;
                right = i + 2;
            }

            while (left >= 1 && right <= 2 * n - 1 && s.charAt(left/2) == s.charAt(right/2)) {
                longest = Math.max(longest, (right - left) / 2 + 1);
                left -= 2;
                right += 2;
            }

        }

        return longest;
    }*/

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
