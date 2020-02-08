package me.xfly.leetcode.binarytree;

import java.time.temporal.ValueRange;

public class BinarySearchTree {

    TreeNode node;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.deleteTest(tree);
    }

    private void findTest() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        tree.node = TreeNode.array2TreeNode(nums);
        TreeNode node = tree.find(50);
        System.out.println();
    }

    private void insertTest(BinarySearchTree tree) {

        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        for (Integer i : nums) {
            tree.insert(i);
        }
        System.out.println();
    }

    private void deleteTest(BinarySearchTree tree) {
        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        for (Integer i : nums) {
            tree.insert(i);
        }
        System.out.println();
        tree.delete(50);
        System.out.println();
    }

    public TreeNode find(int value) {

        while (node != null) {
            if (node.val > value) {
                node = node.left;
            } else if (node.val < value) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

    public void insert(int data) {
        if (node == null) {
            node = new TreeNode(data);
            return;
        }

        TreeNode p = node;

        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        TreeNode p = node;
        TreeNode pp = null;

        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        if (p.left != null && p.right != null) {
            TreeNode miniP = p.right;
            TreeNode miniPP = p;

            while (miniP.left != null) {
                miniPP = miniP;
                miniP = miniPP.left;
            }

            p.val = miniP.val;
            p = miniP;
            pp = miniPP;
        }

        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            node = child;
            return;
        }
        if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

}
