package me.xfly.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_1235 {

    public static void main(String[] args) {
        //int[] startTime = {1, 1, 1}, endTime = {2, 3, 4}, profit = {5, 6, 4};
        //int[] startTime = {1,2,2,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
        //int[] startTime = {4, 2, 4, 8, 2}, endTime = {5, 5, 5, 10, 8}, profit = {1, 2, 8, 10, 4};


       /* int[] startTime = {6, 15, 7, 11, 1, 3, 16, 2},
                endTime = {19, 18, 19, 16, 10, 8, 19, 8},
                profit = {2, 9, 1, 19, 5, 7, 3, 19};*/

        System.out.println(jobSchedulingWithArray(startTime, endTime, profit));
    }

    public static int jobSchedulingWithArray(int[] startTime, int[] endTime, int[] profit) {
        int[] memo = new int[endTime.length];

        Arrays.fill(memo,0);

        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        memo[0] = jobs[0][2];
        for (int i = 1; i < endTime.length; i++) {
            memo[i] = Math.max(memo[i-1],jobs[i][2]);
            for (int j = i - 1; j >= 0; j--) {

                if (jobs[j][1] <= jobs[i][0]) {
                    memo[i] = Math.max(memo[i],jobs[i][2]+memo[j]);
                    break;
                }
            }

        }

        return memo[n-1];
    }

    public static int jobSchedulingWithClass(int[] startTime, int[] endTime, int[] profit) {


        int length = startTime.length;
        int[] memo = new int[length];

        Job[] jobs = new Job[length];

        for (int i = 0; i < length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }


        Arrays.sort(jobs, Comparator.comparingInt(o -> o.end));

        for (int i = 0; i < length; i++){
            memo[i] = jobs[i].profit;
        }

        for (int i = 1; i < length; i++) {
            memo[i] = Math.max(memo[i - 1], jobs[i].profit);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    memo[i] = Math.max(memo[i],memo[j]+jobs[i].profit);
                    break;
                }
            }
        }

        return memo[length - 1];
    }


}


class Job {
    int start;
    int end;
    int profit;

    public Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}
