package me.xfly.leetcode;

public class LeetCode_27 {
	
	public static void main(String[] args) {
		int[] elements = {3,4,5,6,7,8,8,9};
		new LeetCode_27().removeElement(elements, 8);
	}
	
	public int removeElement(int[] nums, int val) {
	    int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}

}
