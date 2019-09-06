package me.xfly.leetcode;

public class LeetCode_198 {

	public static void main(String[] args) {
		int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
        int[] result = new int[nums.length];
        
        if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);
		
        for (int i = 2; i < result.length; i++) {
			result[i] = Math.max(result[i-2]+nums[i], result[i-1]);
		}
		
        return result[result.length-1];
	}

	public static int rob(int[] nums, int index) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (index == 0) {
			return nums[0];
		}
		if (index == 1) {
			return Math.max(nums[0], nums[1]);
		}

		return Math.max(rob(nums, index - 1), rob(nums, index - 2) + nums[index]);
	}
}
