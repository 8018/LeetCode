package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_545_Boundary {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, 4};

        TreeNode node = TreeNode.array2TreeNode(nums);
        boundaryOfBinaryTree(node);
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {


        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (isLeaf(root)) {
            return result;
        }

        List<Integer> leafBoundary = new ArrayList<>();
        List<Integer> rightBounday = new ArrayList<>();
        if (root.left != null) {
            getLeftBoundary(root.left, result);
        }
        getLeafBoundary(root, leafBoundary);
        if (root.right != null) {
            getRightBoundary(root.right, rightBounday);
        }

        result.addAll(leafBoundary);

        for (int i = rightBounday.size() - 1; i >= 0; i--) {
            result.add(rightBounday.get(i));
        }

        return result;
    }

    private static void getLeftBoundary(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (!isLeaf(root)){
                result.add(root.val);
            }
            if (root.left != null) {
                getLeftBoundary(root.left, result);
            } else {
                getLeftBoundary(root.right, result);
            }
        }
    }

    private static void getLeafBoundary(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        getLeafBoundary(root.left, result);
        getLeafBoundary(root.right, result);
    }

    private static void getRightBoundary(TreeNode root, List<Integer> rightBounday) {
        if (root != null) {
            if (!isLeaf(root)){
                rightBounday.add(root.val);
            }
            if (root.right != null) {
                getRightBoundary(root.right, rightBounday);
            } else {
                getRightBoundary(root.left, rightBounday);
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
