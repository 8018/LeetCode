package me.xfly.leetcode;

public class LeetCode_84 {
	public static void main(String[] args) {

	}

	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		int startIndex = 0;
		int endIndex = heights.length - 1;
		int maxArea = 0;
		
		
		while (startIndex <= endIndex) {
			int minHeight = Integer.MAX_VALUE;

			for (int i = startIndex; i <= endIndex; i++) {
				if (heights[i] < minHeight) {
					minHeight = heights[i];
				}
			}
			
			int area = (endIndex - startIndex +1)*minHeight;
			if (area > maxArea) {
				maxArea = area;
			}
			
			if (heights[startIndex] < heights[endIndex]) {
				startIndex++;
			}else {
				endIndex--;
			}
		}
		
		return maxArea;
	}
}
