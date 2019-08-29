package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {
	public static void main(String[] args) {
		int[] nums = { 0,-4,-1,-4,-2,-3,2};
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);

	}

	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		
		if (nums == null || nums.length < 3) {
			return lists;
		}

		Arrays.sort(nums);

		int n = nums.length;

		if (nums[0] > 0 || nums[n - 1] < 0) {
			return lists;
		}

		for (int i = 0; i < n - 2; i++) {
			if (nums[i] > 0) {
				return lists;
			}

			int start = i + 1, end = n - 1;

			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}

			while (start < end) {
				if (nums[i] + nums[start] + nums[end] == 0) {

					List<Integer> integers = new ArrayList<Integer>();
					integers.add(nums[start]);
					integers.add(nums[end]);
					integers.add(nums[i]);
					lists.add(integers);

					while (start<end && nums[start] == nums[start+1]) start++; // 去重
                    while (start<end && nums[end] == nums[end-1]) end--; // 去重

					start++;
					end--;
					continue;
				}

				if (nums[i] + nums[start] + nums[end] < 0) {
					start++;
				}
				if (nums[i] + nums[start] + nums[end] > 0) {
					end--;
				}
			}
		}

		return lists;
	}
}
