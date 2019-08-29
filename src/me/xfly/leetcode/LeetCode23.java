package me.xfly.leetcode;

public class LeetCode23 {

	public static void main(String[] args) {
		ListNode nod1 = new ListNode(1);
		ListNode nod2 = new ListNode(2);
		ListNode nod3 = new ListNode(3);
		ListNode nod4 = new ListNode(4);
		ListNode nod5 = new ListNode(5);
		ListNode nod6 = new ListNode(6);
		ListNode nod7 = new ListNode(7);
		ListNode nod8 = new ListNode(8);
		ListNode nod9 = new ListNode(9);

		nod1.next = nod4;
		nod4.next = nod7;

		nod2.next = nod5;
		nod5.next = nod8;

		nod3.next = nod6;
		nod6.next = nod9;

		ListNode[] lists = { nod1, nod2, nod3 };

		// mergeNode(node, node2);

		ListNode node = mergeKLists(lists);
		System.out.println(node);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		return mergeSortLists(lists, 0, lists.length - 1);
	}

	public static ListNode mergeSortLists(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}

		int m = (start + end) / 2;
		return mergeNode(mergeSortLists(lists, start, m), mergeSortLists(lists, m + 1, end));
	}

	public static ListNode mergeNode(ListNode node1, ListNode node2) {

		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}

		ListNode mergedNode = new ListNode(0);
		ListNode nextNode = mergedNode;

		while (node1 != null && node2 != null) {
			if (node1.val <= node2.val) {
				nextNode.next = node1;
				nextNode = nextNode.next;
				node1 = node1.next;
			} else {
				nextNode.next = node2;
				nextNode = nextNode.next;
				node2 = node2.next;
			}
		}

		while (node1 != null) {
			nextNode.next = node1;
			nextNode = nextNode.next;
			node1 = node1.next;
		}
		while (node2 != null) {
			nextNode.next = node2;
			nextNode = nextNode.next;
			node2 = node2.next;
		}

		return mergedNode.next;
	}
}
