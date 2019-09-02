package me.xfly.leetcode;

public class LeetCode_59 {

	public static void main(String[] args) {
		/*
		 * int n = 3; int[][] matrix = generateMatrix(n); for (int i = 0; i <
		 * matrix.length; i++) { for (int j = 0; j < matrix.length; j++) {
		 * System.out.print(matrix[i][j] + " "); } System.out.println(); }
		 */

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {

		int end = 0;
	    int maxPosition = 0; 
	    int steps = 0;
	    for(int i = 0; i < nums.length - 1; i++){
	        //找能跳的最远的
	        maxPosition = Math.max(maxPosition, nums[i] + i); 
	        if( i == end){ //遇到边界，就更新边界，并且步数加一
	            end = maxPosition;
	            steps++;
	        }
	    }
	    return steps;
	}

	public static int[][] generateMatrix(int n) {
		int l = 0, r = n - 1, t = 0, b = n - 1;
		int[][] mat = new int[n][n];
		int num = 1, tar = n * n;
		while (num <= tar) {
			for (int i = l; i <= r; i++) {
				mat[t][i] = num++; // left to right.
			}
			t++;
			for (int i = t; i <= b; i++) {
				mat[i][r] = num++; // top to bottom.
			}
			r--;
			for (int i = r; i >= l; i--) {
				mat[b][i] = num++; // right to left.
			}
			b--;
			for (int i = b; i >= t; i--) {
				mat[i][l] = num++; // bottom to top.
			}
			l++;
		}
		return mat;
	}
}
