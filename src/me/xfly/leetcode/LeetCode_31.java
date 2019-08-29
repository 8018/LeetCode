package me.xfly.leetcode;

public class LeetCode_31 {

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		new LeetCode_31().nextPermutation(nums);
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	public void reverse(int[] nums, int index) {
		int i = index, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
