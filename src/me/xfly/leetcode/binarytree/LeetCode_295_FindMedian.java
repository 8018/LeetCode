package me.xfly.leetcode.binarytree;


import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_295_FindMedian {

    public static void main(String[] args) {
        LeetCode_295_FindMedian findMedian = new LeetCode_295_FindMedian();
        for (int i = -1; i > -6; i--) {
            findMedian.addNum(i);
            System.out.println(findMedian.findMedian());
        }
    }

    PriorityQueue<Integer> largeQueue;
    PriorityQueue<Integer> smallQueue;

    /**
     * initialize your data structure here.
     */
    public LeetCode_295_FindMedian() {
        largeQueue = new PriorityQueue<>();
        smallQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
    }

    public void addNum(int num) {

        smallQueue.add(num);                                    // Add to max heap

        largeQueue.add(smallQueue.poll());                               // balancing step

        if (smallQueue.size() < largeQueue.size()) {                     // maintain size property
            smallQueue.add(largeQueue.poll());
        }

    }

    public double findMedian() {
        if (largeQueue.size() > smallQueue.size()) {
            return (double) largeQueue.peek();
        } else if (largeQueue.size() < smallQueue.size()) {
            return smallQueue.peek();
        } else {
            return (double) (largeQueue.peek() + smallQueue.peek()) / 2;
        }
    }
}
