package me.xfly.leetcode;

public class LeetCode_25 {

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node.next = node1;
		/*
		 * node1.next = node2; node2.next = node3; node3.next = node4; node4.next =
		 * node5;
		 */
		// node5.next = node6;

		/*
		 * printNode(node);
		 * 
		 * printNode(reverse(node));
		 */

		printNode(reverseKGroup(node, 3));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode reversed = null;
		ListNode pre;
		ListNode next;

		ListNode subHead = head;
		ListNode subTail = null;
		pre = head;
		next = head.next;

		while (next != null) {
			for (int i = 1; i < k; i++) {
				pre = pre.next;

				if (pre == null) {
					break;
				}

				next = next.next;
			}
			if (pre != null) {
				pre.next = null;
				ListNode temp = reverse(subHead);

				if (reversed == null) {
					reversed = temp;
				} else {
					subTail.next = temp;
				}

				subTail = subHead;
				subHead = next;
				pre = next;
				if (next != null) {
					next = next.next;
				}
			}

		}

		if (subTail != null) {
			subTail.next = subHead;
		} else {
			reversed = subHead;
		}

		return reversed;
	}

	public static ListNode reverse(ListNode node) {
		ListNode reversed = null;
		ListNode pre;
		ListNode next;

		pre = node;
		next = node.next;

		while (next != null) {
			pre.next = reversed;
			reversed = pre;
			pre = next;
			next = next.next;
		}

		pre.next = reversed;
		reversed = pre;

		return reversed;
	}

	static void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
