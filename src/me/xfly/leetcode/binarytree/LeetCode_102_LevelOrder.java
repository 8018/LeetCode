package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_102_LevelOrder {

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
        // node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        levelOrder(node);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeNode currentLast = root;
        TreeNode nextLast = root;

        List<TreeNode> nodes = new ArrayList<>();

        List<Integer> level = new ArrayList<>();

        while (root!=null){
            level.add(root.val);
            if (root.left!=null){
                nextLast = root.left;
                nodes.add(root.left);
            }
            if (root.right!=null){
                nextLast = root.right;
                nodes.add(root.right);
            }

            if (root == currentLast){
                currentLast = nextLast;
                result.add(level);
                level = new ArrayList<>();
            }

            if (!nodes.isEmpty()){
                root = nodes.get(0);
                nodes.remove(0);
            }else{
                root = null;
            }

        }



        return result;
    }
}
