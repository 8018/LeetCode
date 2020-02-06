package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node.left = node2;
        node.right = node3;
        node2.left = node4;
    }

    public boolean isValidBST(TreeNode root) {
        if (root== null||(root.left== null && root.right==null)){
            return true;
        }
        return isValidSubBST(root);
    }

    public boolean isValidSubBST(TreeNode root) {
        if (root.left!=null&&root.left.val>root.val){
            return false;
        }

        if (root.right!=null&&root.right.val<root.val){
            return false;
        }

        if (root.left!=null){
           return isValidBST(root.left);
        }
        if (root.right!=null){
            isValidBST(root.right);
        }

        return true;
    }
}
