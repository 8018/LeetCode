package me.xfly.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCod_145 {

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
		// node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		postorderTraversal(node);
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
	    LinkedList<Integer> output = new LinkedList<>();
	    if (root == null) {
	      return output;
	    }

	    stack.add(root);
	    while (!stack.isEmpty()) {
	      TreeNode node = stack.pollLast();
	      output.addFirst(node.val);
	      System.out.println(node.val);
	      if (node.left != null) {
	        stack.add(node.left);
	      }
	      if (node.right != null) {
	        stack.add(node.right);
	      }
	    }
	    return output;
	}
}
