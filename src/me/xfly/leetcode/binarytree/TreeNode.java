package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode array2TreeNode(int[] nums) {
        List<TreeNode> list = new ArrayList();
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (nums[i - 1] > 0) {
                list.add(new TreeNode(nums[i - 1]));
            } else {
                list.add(null);
            }
        }
        for (int i = 1; i <= list.size() / 2 - 1 && list != null; i++) {
            TreeNode node = list.get(i - 1);
            if (node != null) {
                node.left = list.get(i * 2 - 1);
                node.right = list.get(i * 2);
            }
        }
        int lastIndex = list.size() / 2;

        TreeNode last = list.get(lastIndex - 1);

		if (last != null) {
			last.left = list.get(lastIndex * 2 - 1);
			if (list.size() % 2 == 1) {
				last.right = list.get(lastIndex * 2);
			}
		}


        return list.get(0);
    }
}
