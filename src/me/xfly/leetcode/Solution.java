package me.xfly.leetcode;

import me.xfly.leetcode.binarytree.TreeNode;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] ints = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,ints);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        build(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }

    private static void build(TreeNode root, int[] pre, int pLeft, int pRight, int[] in, int iLeft, int iRight) {
        int i;
        for (i = iLeft; i < iRight; i++) {
            if (in[i] == root.val) {
                break;
            }
        }

        int t = i - iLeft;

        if (t > 0) {
            root.left = new TreeNode(pre[pLeft + 1]);
            build(root.left, pre, pLeft + 1, pLeft + 1 + t, in, iLeft, i);
        }

        if (pRight - pLeft - 1 - t > 0) {
            root.right = new TreeNode(pre[pLeft+1+t]);
            build(root.right,pre,pLeft+1+t,pRight,in,i+1,iRight);
        }
    }

}
