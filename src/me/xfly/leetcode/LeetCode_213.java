package me.xfly.leetcode;

public class LeetCode_213 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
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
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public static int robHelper(int[] nums, int start, int end) {
        int pre = nums[start];
        int current = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = current;
            current = Math.max(current, pre + nums[i]);
            pre = temp;
        }

        return current;
    }
}
