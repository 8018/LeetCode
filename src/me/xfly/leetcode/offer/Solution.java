package me.xfly.leetcode.offer;

import me.xfly.leetcode.ListNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        /*int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};*/
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        deleteDuplication(node);

        int[] array = {7, 0};
        /*FindNumsAppearOnce(array,new int[1],new int[1]);

        System.out.println(findFirstBitIs(8));*/
        /*for (int i = 0; i < 10; i++) {
            System.out.println(test(i));
        }*/
    }


    public static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // 相同结点一直前进
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }


    public static int findFirstBitIs(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public static int test(int myxor) {
        int flag = 1;
        while ((myxor & flag) == 0) {
            flag <<= 1;
        }
        return flag;
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;
        int myxor = 0;
        int flag = 1;
        for (int i = 0; i < array.length; ++i)
            myxor ^= array[i];
        while ((myxor & flag) == 0) flag <<= 1;
        // num1[0] = myxor;
        //num2[0] = myxor;
        for (int i = 0; i < array.length; ++i) {
            if ((flag & array[i]) == 0) num2[0] ^= array[i];
            else num1[0] ^= array[i];
        }


    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack2.push(node);

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static int JumpFloorII(int target) {
        return 1 << (target - 1);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
            } else {
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            ans.next = list1;
            ans = ans.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            ans.next = list2;
            ans = ans.next;
            list2 = list2.next;
        }


        return ans.next;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]); // left to right.
            }
            t++;
            if (l > r) {
                break;
            }
            if (t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]); // top to bottom.
            }

            r--;
            if (l > r) {
                break;
            }
            if (t > b) {
                break;
            }
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]); // right to left.
            }
            b--;
            if (l > r) {
                break;
            }
            if (t > b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                ans.add(matrix[i][l]); // bottom to top.
            }
            l++;
        }
        return ans;
    }

    public static double Power(double base, int exponent) {
        boolean flag = exponent < 0;
        if (flag) {
            exponent = -exponent;
        }
        double power = absPower(base, exponent);
        return flag ? 1 / power : power;
    }

    public static double absPower(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double ans = absPower(base, exponent >> 1);
        ans *= ans;
        if ((exponent & 1) == 1) {
            ans *= base;
        }
        return ans;
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode second = first;
        for (int j = 0; j < k; j++) {
            first = first.next;
            if (first == null) {
                return null;
            }
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode h = head;
        ListNode n = head.next;
        ListNode ans = null;

        while (h != null) {
            h.next = ans;
            ans = h;
            h = n;
            if (n != null) {
                n = n.next;
            }
        }

        return ans;

    }

}
