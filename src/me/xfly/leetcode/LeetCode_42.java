package me.xfly.leetcode;

public class LeetCode_42 {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap2(nums));
	}

	public static int trap(int[] height) {
		if (height == null || height.length <= 2) {
			return 0;
		}
		return trap(height, 0, height.length - 1);
	}

	public static int trap(int[] height, int startIndex, int endIndex) {
		if (endIndex - startIndex <= 1) {
			return 0;
		}

		int minHeight = Math.min(height[startIndex], height[endIndex]);
		int minIndex = startIndex;

		for (int i = startIndex + 1; i < endIndex; i++) {
			if (height[i] > minHeight) {
				minHeight = height[i];
				minIndex = i;
			}
		}

		if (minIndex != startIndex) {
			return trap(height, startIndex, minIndex) + trap(height, minIndex, endIndex);
		}

		int capacity = minHeight * (endIndex - startIndex - 1);

		for (int i = startIndex + 1; i < endIndex; i++) {
			capacity -= height[i];
		}
		return capacity;

	}

	public static int trap2(int[] height) {
		int sum = 0;
		int[] max_left = new int[height.length];
		int[] max_right = new int[height.length];

		for (int i = 1; i < height.length - 1; i++) {
			max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
		}
		for (int i = 1; i < height.length - 1; i++) {
			int min = Math.min(max_left[i], max_right[i]);
			if (min > height[i]) {
				sum = sum + (min - height[i]);
			}
		}
		return sum;
	}

}
