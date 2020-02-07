package me.xfly.leetcode;

public class LeetCode_111 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node.left = node2;
        /*node.right = node3;
        // node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/
        System.out.println(minDepth(node));
    }

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left==0){
            return right+1;
        }
        if (right==0){
            return left+1;
        }
        return Math.min(left,right)+1;
    }
}
