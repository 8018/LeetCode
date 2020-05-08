package me.xfly.leetcode.binarytree;

public class LeetCode_1339 {
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
        node2.left = node4;
        node2.right = node5;
        /*node3.left = node6;
        node3.right = node7;*/
        System.out.println(new LeetCode_1339().maxProduct(node));
    }

    double sum;
    double product;
    double partSum;

    public int maxProduct(TreeNode root) {
        sum = getSum(root);
        getProduct(root);
        return (int) (product%(int)(1e9+7));
    }


    public double getProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        partSum = root.val+getProduct(root.left)+getProduct(root.right);
        product = Math.max((sum-partSum)*partSum,product);
        return partSum;
    }


    private  double getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getSum(root.left) + getSum(root.right) + root.val;
    }
}
