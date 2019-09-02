package me.xfly.leetcode;

public class LeetCode_62 {
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		System.out.println(uniquePaths(m, n));
		System.out.println(uniquePaths2(m, n));
	}

	public static int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		} 

		if (m == 1 || n == 1) {
			return 1;
		}

		return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
	}

	public static int uniquePaths2(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] result = new int[m][n];

		for (int i = 0; i < m; i++) {
			result[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			result[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}

		return result[m - 1][n - 1];
	}
}
