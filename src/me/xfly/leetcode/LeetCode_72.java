package me.xfly.leetcode;

public class LeetCode_72 {

	public static void main(String[] args) {
		String a = "Hillo";
		String b = "Hell2";
		minDistance2(a, b);
		System.out.println(minDance);
	}

	static int minDance = Integer.MAX_VALUE;

	public static void minDistance2(String word1, String word2) {
		if ((word1 == null || "".equals(word1)) && (word2 == null || "".equals(word2))) {
			minDance = 0;
		}

		if (word1 == null || "".equals(word1)) {
			minDance = word2.length();
		}

		if (word2 == null || "".equals(word2)) {
			minDance = word1.length();
		}

		char[] a = word1.toCharArray();
		char[] b = word2.toCharArray();

		minDistanceByFlashBack(a, 0, b, 0, 0);
	}

	public static void minDistanceByFlashBack(char[] a, int i, char[] b, int j, int distance) {
		if (i == a.length || j == b.length) {
			if (i < a.length) {
				distance += a.length - i;
			}

			if (j < b.length) {
				distance += b.length - j;
			}
			minDance = Math.min(minDance, distance);
			return;
		}

		if (a[i] == b[j]) {
			minDistanceByFlashBack(a, i + 1, b, j + 1, distance);
		} else {
			minDistanceByFlashBack(a, i + 1, b, j, distance + 1);
			minDistanceByFlashBack(a, i, b, j + 1, distance + 1);
			minDistanceByFlashBack(a, i + 1, b, j + 1, distance + 1);
		}

	}

	public static int minDistance(String word1, String word2) {

		if ((word1 == null || "".equals(word1)) && (word2 == null || "".equals(word2))) {
			return 0;
		}

		if (word1 == null || "".equals(word1)) {
			return word2.length();
		}

		if (word2 == null || "".equals(word2)) {
			return word1.length();
		}

		char[] a = word1.toCharArray();
		int m = a.length;
		char[] b = word2.toCharArray();
		int n = b.length;

		int[][] minDST = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (a[i] == b[0]) {
				minDST[i][0] = i;
			} else if (i != 0) {
				minDST[i][0] = minDST[i - 1][0] + 1;
			} else {
				minDST[i][0] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (b[i] == a[0]) {
				minDST[0][i] = i;
			} else if (i != 0) {
				minDST[0][i] = minDST[0][i - 1] + 1;
			} else {
				minDST[0][i] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i] == b[j]) {
					minDST[i][j] = getMin(minDST[i - 1][j] + 1, minDST[i][j - 1] + 1, minDST[i - 1][j - 1]);
				} else {
					minDST[i][j] = getMin(minDST[i - 1][j] + 1, minDST[i][j - 1] + 1, minDST[i - 1][j - 1] + 1);
				}
			}
		}

		return minDST[m - 1][n - 1];

	}

	static int getMin(int x, int y, int z) {
		int min = x;
		if (y < min) {
			min = y;
		}
		if (z < min) {
			min = z;
		}

		return min;
	}

}
