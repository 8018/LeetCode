package me.xfly.leetcode;

public class FindMedianInTwoArray {
	public static void main(String[] args) {
		int[] nums1 = { 2, 3 };
		int[] nums2 = { 1, 3, 5 };
		System.out.println(findMedianSortedArrays2(nums1, nums2));
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
