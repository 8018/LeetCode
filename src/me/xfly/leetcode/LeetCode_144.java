package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node.left = node2;
		node.right = node3;
		//node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		preorderTraversal(node);

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.println(current.val);
				result.add(current.val);
				stack.push(current);

				current = current.left;
			} else {
				current = stack.pop();
				current = current.right;
			}
		}

		return result;
	}
}
