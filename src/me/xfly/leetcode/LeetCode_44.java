package me.xfly.leetcode;

public class LeetCode_44 {

	public static void main(String[] args) {
		String s = "b";

		String p = "";
		boolean isMatch = isMatch(s, p);
		System.out.println(String.valueOf(isMatch));
	}

	public static boolean isMatch(String s, String p) {

		int m = p.length();
		int n = s.length();

		boolean[][] result = new boolean[m + 1][n + 1];
		result[0][0] = true;

		for (int i = 0; i < m; i++) {
			if ('*' == p.charAt(i) && result[i][0]) {
				result[i + 1][0] = true;
			} else {
				result[i + 1][0] = false;
			}
		}
		for (int i = 1; i <= n; i++) {
			result[0][i] = false;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if ('*' == p.charAt(i)) {
					result[i + 1][j + 1] = result[i][j] || result[i][j + 1] || result[i + 1][j];

				} else {
					if ('?' == p.charAt(i) || p.charAt(i) == s.charAt(j)) {
						result[i + 1][j + 1] = result[i][j];
					} else {
						result[i + 1][j + 1] = false;
					}

				}
			}
		}

		return result[m][n];
	}

}
