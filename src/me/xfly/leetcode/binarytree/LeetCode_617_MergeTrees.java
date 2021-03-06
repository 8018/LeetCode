package me.xfly.leetcode.binarytree;

public class LeetCode_617_MergeTrees {
        public static void main(String[] args) {
        int[] nums = {1,2,3,-1,-1,5};
        TreeNode node = TreeNode.array2TreeNode(nums);
        System.out.println();
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }

        t1.val = t1.val+t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
