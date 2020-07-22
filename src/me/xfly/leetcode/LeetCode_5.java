package me.xfly.leetcode;

public class LeetCode_5 {

    public static void main(String[] args) {
        String string = "aaabacdcab";
        System.out.println(new LeetCode_5().longestPalindromeByManacher(string));
    }

    public String longestPalindromeByManacher(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        String str = addBoundaries(s, '#');
        int newLength = 2 * len + 1;
        int start = 0;
        int maxLen = 1;


        int maxRight = 0;
        int center = 0;
        int[] p = new int[newLength];

        for (int i = 0; i < newLength; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                p[i] = Math.min(p[mirror], maxRight - i);
            }

            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            while (left >= 0 && right < newLength && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;
            }

            if (i + p[i] > maxRight) {
                maxRight = i + p[i];
                center = i;
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }


        return s.substring(start, start + maxLen);
    }


    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = 0;
        int maxLength = 0;

        //数组下标要特别注意
        for (int i = 0; i <= 2 * n - 1; i++) {
            int length = getLongestPalindrome(chars, i / 2, (i + 1) / 2);
            if (length > maxLength) {
                //长度为 length 的字符串，它的尾标-首标的距离其实是 leng -1
                start = (i + 1) / 2 - length / 2;
                end = (i + 1) / 2 + (length - 1) / 2;
                maxLength = length;
            }
        }

        return s.substring(start, end + 1);
    }

    public int getLongestPalindrome(char[] chars, int l, int r) {
        int left = l, right = r;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        //当前回文串的长度
        //left 指向回文串前面一位，right 指向回文串后一位
        //回文串夹在中间，减一才是回文串的真正长度
        return right - left - 1;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        int result = R - L - 1;
        return result;
    }

}
