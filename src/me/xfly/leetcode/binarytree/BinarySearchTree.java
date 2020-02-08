package me.xfly.leetcode.binarytree;

import java.time.temporal.ValueRange;

public class BinarySearchTree {

    TreeNode node;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.deleteTest(tree);
    }

    private void findTest() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        tree.node = TreeNode.array2TreeNode(nums);
        TreeNode node = tree.find(50);
        System.out.println();
    }

    private void insertTest(BinarySearchTree tree) {

        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        for (Integer i : nums) {
            tree.insert(i);
        }
        System.out.println();
    }

    private void deleteTest(BinarySearchTree tree) {
        int[] nums = {33, 20, 50, 17, 30, 40, 60};
        for (Integer i : nums) {
            tree.insert(i);
        }
        System.out.println();
        tree.delete(50);
        System.out.println();
    }

    public TreeNode find(int value) {

        while (node != null) {
            if (node.val > value) {
                node = node.left;
            } else if (node.val < value) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

    public void insert(int data) {
        if (node == null) {
            node = new TreeNode(data);
            return;
        }

        TreeNode p = node;

        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除节点的时候有三种情况
     * 1、被删节点没有子节点，可以直接删除
     * 2、被删节点有一个子节点，子节点代替被删节点
     * 3、被删节点有两个子节点，找右子树的最小值（左子树的最大值）跟被删节点交换
     *    交换后情况变成 1 或 2
     * */
    public void delete(int data) {
        //指向被删除的节点，初始指向根节点
        TreeNode p = node;
        //指向被删节点的父节点
        TreeNode pp = null;

        //找到要被删节点
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        //如果被删节点有两个子节点，找一个节点跟目标节点交换
        if (p.left != null && p.right != null) {
            TreeNode miniP = p.right;
            TreeNode miniPP = p;

            while (miniP.left != null) {
                miniPP = miniP;
                miniP = miniPP.left;
            }

            p.val = miniP.val;
            p = miniP;
            pp = miniPP;
        }

        //两个child 的情况处理过之后，变成只有一个或没有 child，找到这个child
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //pp == null 目标节点是根节点
        if (pp == null) {
            node = child;
            return;
        }
        //将目标节点替换成它的 child
        if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

}
