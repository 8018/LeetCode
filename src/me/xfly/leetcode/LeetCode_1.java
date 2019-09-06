package me.xfly.leetcode;

import java.util.HashMap;

public class LeetCode_1 {
	public static void main(String[] args) {
		int[] nums = {1,3,5,2,8};
		int[] result = twoSum(nums, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.print("index="+result[i]+" ");
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
		//用 HashMap 存储已经遍历数据
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			//如果当前数据和已经遍历的某个数据和等于 target 返回
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			//将数据存入 map
			map.put(nums[i], i);
		}

		return null;
	}
}
