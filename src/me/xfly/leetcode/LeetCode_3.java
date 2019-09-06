package me.xfly.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 {
	public static void main(String[] args) {
		String string = "pwwkew";
		System.out.println(lengthOfLongestSubstring(string));
	}

	public static int lengthOfLongestSubstring(String s) {
		int length = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		for (int i = 0, j = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				//如果前面已经有这个字符 第一个指针移动到这个字符串之后
				j = Math.max(map.get(chars[i])+1, j);
				//++ 不行 ++ 表示后移一位，后移一位达不到指定位置
				//j++;
			}

			length = Math.max(length, i - j + 1);
			//为什么是 i+1？
			//因为如果最新字符在 map 中可以找到，前一个字符要被跳过，指针指向它的下一位
			map.put(chars[i], i);
		}
		return length;
	}

}
