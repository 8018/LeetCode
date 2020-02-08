package me.xfly.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_971 {




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(46);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(14);

        /*node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/

        TreeNode node8 = new TreeNode(48);
        TreeNode node9 = new TreeNode(29);
        TreeNode node10 = new TreeNode(6);
        TreeNode node11 = new TreeNode(37);
        TreeNode node12 = new TreeNode(10);
        TreeNode node15 = new TreeNode(15);

        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node7.right = node15;

        //26,3,50,42,45,null,17,40,null,null,18,null,null,25,11,31,
        TreeNode node16 = new TreeNode(26);
        TreeNode node17 = new TreeNode(3);
        TreeNode node18 = new TreeNode(50);
        TreeNode node19 = new TreeNode(42);
        TreeNode node20 = new TreeNode(45);
        TreeNode node22 = new TreeNode(17);
        TreeNode node23 = new TreeNode(40);
        TreeNode node26 = new TreeNode(18);


        node8.left = node16;
        node8.right = node17;
        node9.left = node18;
        node9.right = node19;
        node10.left = node20;
        node11.left = node22;
        node11.right = node23;
        node15.left = node26;

        //26,3, 50,42, 45,null, 17,40, null,null,18,null
          //26        3       50          42        45        17         40       18
        //null,25  ,11,31  ,41,null,  null,null,  1,null  ,null,null,  22,19,  null,null,

        TreeNode node29 = new TreeNode(25);
        TreeNode node30 = new TreeNode(11);
        TreeNode node31 = new TreeNode(31);
        TreeNode node32 = new TreeNode(41);
        TreeNode node33 = new TreeNode(1);
        TreeNode node34 = new TreeNode(22);
        TreeNode node35 = new TreeNode(19);

        node16.right = node29;
        node17.left = node30;
        node17.right = node31;
        node18.left = node32;
        node20.left = node33;
        node22.left = node34;
        node22.right = node35;

        //25  ,11 ,31  ,41 ,1,22,19
        //null,null ,13,null, null,null, null,34, null,null, 27,null, 23,null,

        TreeNode node36 = new TreeNode(13);
        TreeNode node37 = new TreeNode(34);
        TreeNode node38 = new TreeNode(27);
        TreeNode node39 = new TreeNode(23);

        node30.left = node36;
        node32.right = node37;
        node34.left = node38;
        node35.left = node39;

        //13 34, 27,, 23,,
        //28,38, null,null, 33,null ,16,20,

        TreeNode node40 = new TreeNode(28);
        TreeNode node41 = new TreeNode(38);
        TreeNode node42 = new TreeNode(33);
        TreeNode node43 = new TreeNode(16);
        TreeNode node44 = new TreeNode(20);

        node36.left = node40;
        node36.right = node41;
        node38.left = node42;
        node39.left = node43;
        node39.right = node44;

        //28,38, null,null, 33,null ,16,20,
        //null,null, 43,null, 44,35, 5,49 ,21,36,

        TreeNode node45 = new TreeNode(43);
        TreeNode node46 = new TreeNode(44);
        TreeNode node47 = new TreeNode(35);
        TreeNode node48 = new TreeNode(5);
        TreeNode node49 = new TreeNode(49);
        TreeNode node50 = new TreeNode(21);
        TreeNode node51 = new TreeNode(36);

        node41.left = node45;
        node42.left = node46;
        node42.right = node47;
        node43.left = node48;
        node43.right = node49;
        node44.left = node50;
        node44.right = node51;

        //null,null, 43,null, 44,35, 5,49 ,21,36,
        //24,null,2,47,null,null,null,null,null,39,null,null,null,null
        TreeNode node52 = new TreeNode(24);
        TreeNode node53 = new TreeNode(2);
        TreeNode node54 = new TreeNode(47);
        TreeNode node55 = new TreeNode(39);


        node45.left = node52;
        node46.left = node53;
        node46.right = node54;
        node49.right = node55;

        //null,null,null,32,null,30]
        TreeNode node56 = new TreeNode(32);
        TreeNode node57 = new TreeNode(30);
        node53.right = node56;
        node54.right = node57;

        int[] voyage = {100,9,4};
        //int[] voyage = {100, 9, 12, 29, 42, 50, 41, 34, 48, 26, 25, 49, 31, 11, 13, 38, 43, 24, 28, 46, 6, 45, 1, 37, 40, 22, 27, 33, 44, 47, 30, 2, 32, 35, 19, 23, 16, 5, 3, 39, 20, 36, 21, 17, 4, 14, 15, 18, 7, 10};


        System.out.println(new LeetCode_971().flipMatchVoyage(node1, voyage));

    }

    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        iterator(root, voyage, result);
        return result;
    }

    public void iterator(TreeNode root, int[] voyage, List<Integer> result) {
        if ((root.left == null && root.right == null) || index >= voyage.length) {
            return;
        }

        if (root.val != voyage[index]){
            result.clear();
            result.add(-1);
        }

        int nextValue = voyage[index + 1];

        int leftValue = -1;
        int rightValue = -1;
        if (root.left != null) {
            leftValue = root.left.val;
        }

        if (root.right != null) {
            rightValue = root.right.val;
        }

        //判断两个孩子节点的值是否有一个和数组中下一个 value 相等
        //不相等说明 voyage 不匹配
        if (leftValue != nextValue && rightValue != nextValue) {
            result.clear();
            result.add(-1);
            return;
        }

        //如果右孩子和下一个 value 相等 交换左右节点
        if (root.right != null && root.right.val == nextValue) {

            if (root.left != null) {
                result.add(voyage[index]);
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;


        }

        index = index + 1;
        iterator(root.left, voyage, result);

        if (root.right != null) {
            //这里要再判断一次 漏掉会出错
            //因为上面的判断已经被消费
            nextValue = voyage[index + 1];
            if (nextValue != root.right.val){
                result.clear();
                result.add(-1);
                return;
            }

            index = index + 1;
            iterator(root.right, voyage, result);
        }

    }

    /*void dfs(TreeNode root, int[] voyage, List<Integer> result) {
        if (root != null) {
            if (root.val != voyage[index++]) {
                result.clear();
                result.add(-1);
                return;
            }

            if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
                result.add(root.val);
                dfs(root.right,voyage,result);
                dfs(root.left,voyage,result);

            }else{
                dfs(root.left,voyage,result);
                dfs(root.right,voyage,result);
            }
        }
    }*/


}
