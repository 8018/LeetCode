package me.xfly.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_116 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        connect3(node1);
    }


    public static Node connect(Node root) {
        if (root == null) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static Node connect3(Node root) {
        if (root == null) return root;

        Node worker = root;
        //当前层第一个节点
        Node levelFirst = root;
        //当前层最后一个节点
        Node levelLast = root;

        while (worker.left!=null) {
            //两个孩子连接
            worker.left.next = worker.right;
            if (worker == levelLast){
                //换行
                //左等于左的左
                levelFirst = levelFirst.left;
                //右等于右的右
                levelLast = levelLast.right;
                worker = levelFirst;
            }else{
                //当前节点和下一节点连接
                worker.right.next = worker.next.left;
                //后移一位
                worker = worker.next;
            }
        }

        return root;
    }


    public static Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Node last = root;
        Node nextLast = root;
        Node pri = null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node next = queue.poll();
            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
                nextLast = next.right;
            }
            System.out.print(next.val);

            if (pri != null) {
                pri.next = next;
            }
            pri = next;

            if (next == last) {
                System.out.println();
                last = nextLast;
                pri = null;
            }

        }

        return root;

    }


}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}