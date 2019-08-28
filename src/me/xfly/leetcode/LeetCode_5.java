package me.xfly.leetcode;

public class LeetCode_5 {

	public static void main(String[] args) {
		String string = "bb";
		System.out.println(new LeetCode_5().longestPalindrome(string));
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
