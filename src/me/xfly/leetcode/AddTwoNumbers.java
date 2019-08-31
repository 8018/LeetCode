package me.xfly.leetcode;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = resultHead;
		// 进位
		int carry = 0;
		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int value = x + y + carry;
			// 进位
			carry = value / 10;
			// 当前位的实际数值
			curr.next = new ListNode(value % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}

		}
		// 如果最后仍有进位，用一个节点保存进位
		if (carry != 0) {
			curr.next = new ListNode(carry);
		}

		return resultHead.next;

	}
}
