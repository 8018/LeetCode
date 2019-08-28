package me.xfly.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_142 {

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node2;

		System.out.println(detectCycleWithIndex(node));
	}

	public static ListNode detectCycleWithSet(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head)) {
				return head;
			}
			set.add(head);
			head = head.next;
		}
		return null;
	}

	public static ListNode detectCycleWithIndex(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (p != null && p.next != null) {
			p = p.next.next;
			q = q.next;
			if (p == q) {
				return findTargetNode(head, p);
			}

		}

		return null;
	}

	public static ListNode findTargetNode(ListNode head, ListNode p) {
		while (true) {
			if (p == head) {
				return p;
			}
			p = p.next;
			head = head.next;
		}
	}
}
