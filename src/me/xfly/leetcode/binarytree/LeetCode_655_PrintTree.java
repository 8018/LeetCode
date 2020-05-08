package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_655_PrintTree {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeNode root = TreeNode.array2TreeNode(nums);

        List<List<String>> result = printTree(root);
        System.out.println();
    }

    public static List<List<String>> printTree(TreeNode root) {

        int height = TreeNode.maxDepth(root);

        List<List<String>> lists = new ArrayList<>();
        int length = (int) (Math.pow(2,height)-1);

        for (int i = 0; i < height; i++) {
            List<String> subLists = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                subLists.add("=");
            }
            lists.add(subLists);
        }

        int index = length/2;
        lists.get(0).remove(index);
        lists.get(0).add(index,String.valueOf(root.val));

        dfs(root.left,1,height,index,false,lists);
        dfs(root.right,1,height,index,true,lists);

        for (List<String> strs:lists){
            for (String str:strs){
                System.out.print(str);
            }
            System.out.println();
        }


        return lists;
    }

    private static void dfs(TreeNode node,int level,int height,int parentIndex,boolean isRight,List<List<String>> result){
        if (node != null){
            //子节点和父节点的距离
            int margin = (int) Math.pow(2,height-level-1);
            int index = parentIndex - margin;
            if (isRight){
                index = parentIndex+margin;
            }

            result.get(level).remove(index);
            result.get(level).add(index,String.valueOf(node.val));

            //递归处理子节点

            dfs(node.left,level+1,height,index,false,result);
            dfs(node.right,level+1,height,index,true,result);
        }
    }
}
