package me.xfly.leetcode.binarytree;

public class LeetCode_215 {

    public static void main(String[] args) {
        int[] nums = {2,-1,0};
        System.out.println(findKthLargest(nums,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        LowerHeap heap = new LowerHeap(k);
        for (Integer i:nums){
            if (!heap.isFull()){
                heap.insert(i);
            }else{
                if (heap.getMin() < i){
                    heap.removeMin();
                    heap.insert(i);
                }
            }

        }
        return heap.removeMin();
    }
}
