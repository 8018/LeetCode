package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94 {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node.right = node2;
		node2.left = node3;

		inorderTraversalWithStack(node);
	}

	
	/**
	 * 迭代的方式实现中序遍历
	 * 1、先把所有左子节点加入栈中
	 * 2、出栈，打印当前值，当前节点的右节点执行步骤 1 
	 */
	public static List<Integer> inorderTraversalWithStack(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		List<Integer> result = new ArrayList<Integer>();

		addNodeToStack(stack, root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			
			result.add(node.val);
			
			System.out.println(node.val);

			if (node.right != null) {
				addNodeToStack(stack, node.right);
			}
		}
		
		return result;
	}
	
	public static void addNodeToStack(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public static List<Integer> inorderTraversal2(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null) {
			return result;
		}

		result.addAll(inorderTraversal2(root.left));
		result.add(root.val);
		result.addAll(inorderTraversal2(root.right));

		return result;
	}


	
}
