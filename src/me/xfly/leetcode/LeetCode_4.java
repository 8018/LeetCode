package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_4 {
	public static void main(String[] args) {
		/*int[] nums1 = { 2, 3 };
		int[] nums2 = { 1, 3, 5 };
		System.out.println(findMedianSortedArrays2(nums1, nums2));*/

		//multiply("123","23");
		/*int[] nums1 = { 1,2, 3 };

		permute(nums1);*/

		//grayCode(3);

		ListNode nod1 = new ListNode(1);
		ListNode nod2 = new ListNode(2);
		ListNode nod3 = new ListNode(3);
		ListNode nod4 = new ListNode(4);
		ListNode nod5 = new ListNode(5);
		ListNode nod6 = new ListNode(6);
		ListNode nod7 = new ListNode(7);
		ListNode nod8 = new ListNode(8);
		ListNode nod9 = new ListNode(9);

		nod1.next = nod2;
		nod2.next = nod3;

		nod3.next = nod4;
		nod4.next = nod5;

		nod5.next = nod6;
		nod6.next = nod7;
		nod7.next = nod8;
		nod8.next = nod9;
		reverseList(nod1);
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}


	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<>();
		int num = 1 << n;
		for (int i = 0; i < num; i++) {
			res.add(i >> 1 ^ i);
		}
		return res;
	}



	public static void backtrack(int n,
						  ArrayList<Integer> output,
						  List<List<Integer>> res,
						  int first) {
		// 所有数都填完了
		if (first == n)
			res.add(new ArrayList<Integer>(output));
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);
			// 继续递归填下一个数
			backtrack(n, output, res, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList();

		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int num : nums)
			output.add(num);

		int n = nums.length;
		backtrack(n, output, res, 0);
		return res;
	}



	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] res = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				int sum = (res[i + j + 1] + n1 * n2);
				res[i + j + 1] = sum % 10;
				res[i + j] += sum / 10;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0) continue;
			result.append(res[i]);
		}
		return result.toString();
	}

	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int mLength = nums1.length;
		int nLength = nums2.length;
		int left = (mLength + nLength + 1) / 2;
		int right = (mLength + nLength + 2) / 2;
		return (findKthSmallestNumber(nums1, 0, mLength - 1, nums2, 0, nLength - 1, left)
				+ findKthSmallestNumber(nums1, 0, mLength - 1, nums2, 0, nLength - 1, right)) / 2.0d;
	}

	/**
	 * 找出第 k 小的数字
	 */
	public static int findKthSmallestNumber(int[] nums1, int mStart, int mEnd, int[] nums2, int nStart, int nEnd,
			int k) {
		int mLength = mEnd - mStart + 1;
		int nLength = nEnd - nStart + 1;
		//保证 nums1 是长度较短的那个
		if (mLength > nLength) {
			return findKthSmallestNumber(nums2, nStart, nEnd, nums1, mStart, mEnd, k);
		}

		//nums1 所有数据都不合适，直接从 nums2 中返回
		if (mLength == 0) {
			return nums2[nStart + k - 1];
		}

		//第一小，返回两个数组开头较小的那个
		if (k == 1) {
			return Math.min(nums1[mStart], nums2[nStart]);
		}

		//i j 是数组下标，k 是第  k 小，注意数组下标
		int i = mStart + Math.min(mLength, k / 2) - 1;
		int j = nStart + Math.min(nLength, k / 2) - 1;

		// i - mStart + 1 表示已经有这么多数据不合适所以 k 要减去它
		if (nums1[i] < nums2[j]) {
			return findKthSmallestNumber(nums1, i + 1, mEnd, nums2, nStart, nEnd, k - (i - mStart + 1));
		} else {
			return findKthSmallestNumber(nums1, mStart, mEnd, nums2, j + 1, nEnd, k - (j - nStart + 1));
		}
	}

	/**
	 * 合并数组，然后找出中位数
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) { int m = nums1.length;
		int n = nums2.length;
		int length = m + n;
		int firstNumber = (length - 1) / 2;
		int secondNumber = (length - 1) / 2 + 1;

		int[] nums3 = new int[length];

		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums3[k] = nums1[i];
				i++;
			} else {
				nums3[k] = nums2[j];
				j++;
			}
			k++;
		}

		if (m - 1 >= 0 && i <= m - 1) {
			for (; i < m; i++) {
				nums3[k] = nums1[i];
				k++;
			}
		}

		if (n - 1 >= 0 && j <= n - 1) {
			for (; j < n; j++) {
				nums3[k] = nums2[j];
				k++;
			}
		}

		if (length % 2 == 0) {
			return (nums3[firstNumber] + nums3[secondNumber]) / 2.0d;
		} else {
			return nums3[firstNumber];
		}

	}
}
