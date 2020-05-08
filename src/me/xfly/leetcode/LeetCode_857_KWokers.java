package me.xfly.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_857_KWokers {

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        mincostToHireWorkers(quality, wage, 2);
    }


    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        Queue<Integer> queue = new PriorityQueue<>();
        double ans = Double.MAX_VALUE;
        int sumQ = 0;

        for (Worker worker : workers) {
            queue.add(-worker.quality);
            sumQ += worker.quality;
            if (queue.size() > K) {
                sumQ+=queue.poll();
            }
            if (queue.size() == K) {
                ans = Math.min(ans,sumQ*worker.ratio());
            }
        }
        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}

