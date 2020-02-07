package me.xfly.leetcode;

public class LeetCode_80 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int currentNum = nums[0];
        int times = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                times++;
                if (times <= 2) {
                    nums[index] = nums[i];
                    index++;

                }
            } else {
                currentNum = nums[i];
                times = 1;
                nums[index] = nums[i];
                index++;

            }
        }

        return index;
    }
}
