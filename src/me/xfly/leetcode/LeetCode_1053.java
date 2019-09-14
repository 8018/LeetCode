package me.xfly.leetcode;

public class LeetCode_1053 {
	
	public static void main(String[] args) {
		int[] nums = {3,1,1,3};
		new LeetCode_1053().prevPermOpt1(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public int[] prevPermOpt1(int[] nums) {
		
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		
		
		int index = -1;
		
		for (int j = nums.length-2; j >=0; j--) {
			if (nums[j]>nums[j+1]) {
				index = j;
				break;
			}
		}
		

		if (index == -1) {
			return nums;
		}
		
		int temp = 0;
		int nextIndex = -1;
		for (int i = index+1; i < nums.length; i++) {
			if (nums[i]< nums[index] && nums[i] > temp) {
				temp = nums[i];
				nextIndex = i;
			}
		}
		
		swap(nums, index, nextIndex);
		
		return nums;
	}
	
	public void swap(int[] a,int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
