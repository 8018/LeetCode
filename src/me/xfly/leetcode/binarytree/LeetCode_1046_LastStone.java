package me.xfly.leetcode.binarytree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_1046_LastStone {
    public static void main(String[] args) {
        int[] stones = {7,6,7,6,9};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {

        if (stones.length<=1){
            return stones[0];
        }

        int[] largeStones = new int[stones.length+1];
        for (int i = 0; i < stones.length; i++) {
            largeStones[i+1] = stones[i];
        }

        Heap heap = Heap.buildHeap(largeStones,stones.length,stones.length);


        int result = 0;
        while (heap.size()>=2){
            int stone1 = heap.removeMax();
            int stone2 = heap.removeMax();
            result = Math.abs(stone1-stone2);
            heap.insert(result);

        }
        if (heap.size()==1){
            result = heap.removeMax();
        }
        return result;
    }
}
