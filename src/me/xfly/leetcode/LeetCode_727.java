package me.xfly.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_727 {

    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(minWindowWithDp(s,"ac"));
    }

    public static String minWindow(String S, String T) {

        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        int count = T.length();
        for (int i = 0;i<count;i++){
            char c = T.charAt(i);
            if (!need.containsKey(c)){
                need.put(c,1);
            }else{
                need.put(c,need.get(c)+1);
            }
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < S.length()) {
            // c 是将移入窗口的字符
            char c = S.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {

                int size = window.get(c)==null?0:window.get(c);
                window.put(c,size+1);

                if (need.containsKey(c) && window.get(c) == need.get(c))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = S.charAt(left);
                // 左窗右移
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "not find" : S.substring(start, len);
    }

    public static String minWindowWithDp(String S,String T){
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == n + 1 ? "not find" : S.substring(start, start + len);
    }
}
