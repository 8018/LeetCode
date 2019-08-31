package me.xfly.leetcode;

public class LeetCode_8 {

	public static void main(String[] args) {
		System.out.println(new LeetCode_8().myAtoi("-91283472332"));
	}

	public int myAtoi(String str) {
		str = str.trim();
		if (str == null || str.length() == 0) {
			return 0;
		}

		char[] chars = str.toCharArray();

		Character chas = chars[0];

		if (chas == '-' ||chas == '+' || Character.isDigit(chas)) {
			return getNumber(chars, 0);
		}

		return 0;
	}

	int getNumber(char[] chars, int index) {
		int sign = 1;
		if (chars[0] == '-') {
			sign = -1;
			++index;
		}else if (chars[0] == '+') {
			++index;
		}

		int number = 0;

		for (int i = index; i < chars.length; i++) {
			if (Character.isDigit(chars[i])) {
				int temp = chars[i] - '0';

				if (sign == -1) {
					temp = temp * sign;
				}

				if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && temp > 7))
					return Integer.MAX_VALUE;
				if (number < Integer.MIN_VALUE / 10 || (number == Integer.MIN_VALUE / 10 && temp < -8))
					return Integer.MIN_VALUE;
				number = number * 10 + temp;
			} else {
				break;
			}
		}

		return number;

	}
}
