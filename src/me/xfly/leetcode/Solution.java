package me.xfly.leetcode;

import me.xfly.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, 4};
        TreeNode node = TreeNode.array2TreeNode(nums);
        boundaryOfBinaryTree(node);
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left_boundary = new LinkedList<>(), right_boundary = new LinkedList<>(), leaves = new LinkedList<>();
        preorder(root, left_boundary, right_boundary, leaves, 0);
        left_boundary.addAll(leaves);
        left_boundary.addAll(right_boundary);
        return left_boundary;
    }

    public static boolean isLeaf(TreeNode cur) {
        return (cur.left == null && cur.right == null);
    }

    public static boolean isRightBoundary(int flag) {
        return (flag == 2);
    }

    public static boolean isLeftBoundary(int flag) {
        return (flag == 1);
    }

    public static boolean isRoot(int flag) {
        return (flag == 0);
    }

    public static int leftChildFlag(TreeNode cur, int flag) {
        if (isLeftBoundary(flag) || isRoot(flag))
            return 1;
        else if (isRightBoundary(flag) && cur.right == null)
            return 2;
        else return 3;
    }

    public static int rightChildFlag(TreeNode cur, int flag) {
        if (isRightBoundary(flag) || isRoot(flag))
            return 2;
        else if (isLeftBoundary(flag) && cur.left == null)
            return 1;
        else return 3;
    }

    public static void preorder(TreeNode cur, List<Integer> left_boundary, List<Integer> right_boundary, List<Integer> leaves, int flag) {
        if (cur == null)
            return;
        if (isRightBoundary(flag))
            right_boundary.add(0, cur.val);
        else if (isLeftBoundary(flag) || isRoot(flag))
            left_boundary.add(cur.val);
        else if (isLeaf(cur))
            leaves.add(cur.val);
        preorder(cur.left, left_boundary, right_boundary, leaves, leftChildFlag(cur, flag));
        preorder(cur.right, left_boundary, right_boundary, leaves, rightChildFlag(cur, flag));
    }

}
