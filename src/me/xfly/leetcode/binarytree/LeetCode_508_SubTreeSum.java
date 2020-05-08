package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_508_SubTreeSum {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node.left = node2;
        node.right = node3;
        // node2.left = node4;
        /*node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/
        findFrequentTreeSum(node);

    }

    static int maxTimes = Integer.MIN_VALUE;

    public static int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer,Integer> map = new HashMap<>();
        getSum(root,map);

        ArrayList<Integer> list=new ArrayList<Integer>();

        for (Integer key : map.keySet()) {
           if (map.get(key) == maxTimes){
               list.add(key);
           }
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = list.get(i);
        }

        return results;
    }

    /*private static void dfs(TreeNode node,Map<Integer,Integer> map) {
        if (node == null) {
            return;
        }

        int sum = getSum(node);

        int size = 1;
        if (map.get(sum) != null){
            size = map.get(sum)+1;
        }

        if (size>maxTimes){
            maxTimes = size;
        }

        map.put(sum,size);
        dfs(node.left,map);
        dfs(node.right,map);
    }*/

    private static int getSum(TreeNode root,Map<Integer,Integer> map) {
        if (root == null) {
            return 0;
        }

        int sum = getSum(root.left,map) + getSum(root.right,map) + root.val;;

        int size = 1;
        if (map.get(sum) != null){
            size = map.get(sum)+1;
        }

        if (size>maxTimes){
            maxTimes = size;
        }

        map.put(sum,size);

        return sum;
    }
}
