package me.xfly.leetcode;

public class LeetCode_11 {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	
	/**
	 * 最短的那个边决定桶的容量，所以如果某个边是最小的，选择从这个边往前进一位
	 */
	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int max = 0;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			if (area > max) {
				max = area;
			}

			if (height[i] <= height[j]) {
				i++;
			} else {
				j--;
			}

		}

		return max;
	}
}
