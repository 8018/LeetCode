package me.xfly.leetcode;

import me.xfly.leetcode.binarytree.TreeNode;
import org.omg.CORBA.IRObject;

import java.util.HashMap;

public class LeetCode_337 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,-1,3,-1,1};
        TreeNode root = TreeNode.array2TreeNode(nums);

        LeetCode_337 leetCode_337 = new LeetCode_337();
        System.out.println(leetCode_337.rob3(root));
    }
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int val = root.val;
        if (root.left!=null){
            val+= rob1(root.left.left)+rob1(root.left.right);
        }
        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }

        val = Math.max(val,rob1(root.left)+rob1(root.right));
        return val;
    }

    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();

        return rob2Helper(root,memo);
    }

    public int rob2Helper(TreeNode root,HashMap<TreeNode, Integer> memo) {
        if (root == null){
            return 0;
        }

        if (memo.containsKey(root)){
            return memo.get(root);
        }

        int val = root.val;
        if (root.left!=null){
            val+= rob1(root.left.left)+rob1(root.left.right);
        }
        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }

        val = Math.max(val,rob1(root.left)+rob1(root.right));

        memo.put(root,val);

        return val;
    }

    public int rob3(TreeNode root) {
        return Math.max(rob3Helper(root)[0],rob3Helper(root)[1]);
    }

    public int[] rob3Helper(TreeNode root){
        int[] result = new int[2];
        if (root == null) return result;

        int[] left = rob3Helper(root.left);
        int[] right = rob3Helper(root.right);

        result[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        result[1] = left[0]+right[0]+root.val;

        return result;
    }
}
