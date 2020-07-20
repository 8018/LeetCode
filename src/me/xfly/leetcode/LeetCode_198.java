package me.xfly.leetcode;

public class LeetCode_198 {

	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

        if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int pre = nums[0];
		int current = Math.max(nums[0],nums[1]);

		for (int i=2;i<nums.length;i++){
			int temp = current;
			current = Math.max(current,pre+nums[i]);
			pre = temp;
		}

        return current;
	}

}
