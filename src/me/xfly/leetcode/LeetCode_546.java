package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_546 {

    public static void main(String[] args) {
        int[] boxes = {1,3,2,2,2,3,4,3,1,1,3,2,2,2,3,4,3,1,1,3,2,2,2,3,4,3,1,1,3,2,2,2,3,4,3,1,1,3,2,2,2,3,4,3,1};
        //int[] boxes = {1, 2};
        LeetCode_546 l546 = new LeetCode_546();
        System.out.println(l546.removeBoxesWithMemo(boxes));
    }

    public int removeBoxesWithMemo(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
    }

    public int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }


    int result = 0;
    int temp = 0;

    public int removeBoxes(int[] boxes) {
        List<Integer> arr = new ArrayList<>();
        for (int i : boxes) {
            arr.add(i);
        }

        return backTrack((ArrayList<Integer>) arr);
    }

    public int backTrack(ArrayList<Integer> boxes) {

        if (boxes.size() == 0) {
            if (temp > result) {
                result = temp;
            }
            return result;
        }

        for (int i = 0; i < boxes.size(); i++) {
            int num = boxes.get(i);
            int left = i, right = i;
            while (left - 1 >= 0 && boxes.get(left - 1) == boxes.get(i)) {
                left--;
            }

            while (right < boxes.size() - 1 && boxes.get(right + 1) == boxes.get(i)) {
                right++;
            }

            for (int j = 0; j < right - left + 1; j++) {
                boxes.remove(left);
            }

            int plus = (right - left + 1) * (right - left + 1);

            temp += plus;

            backTrack(boxes);

            temp -= plus;

            for (int j = 0; j < right - left + 1; j++) {
                boxes.add(left + j, num);
            }

        }

        return result;
    }
}
