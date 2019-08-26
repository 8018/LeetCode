package me.xfly.leetcode;

import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {1,3,5,2,8};
		int[] result = twoSum(nums, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {

				return new int[] { map.get(target - nums[i]), i };
			}

			map.put(nums[i], i);
		}

		return null;
	}
}
