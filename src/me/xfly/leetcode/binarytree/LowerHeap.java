package me.xfly.leetcode.binarytree;

public class LowerHeap {
    private int[] a;
    private int count;
    private int capacity;

    public LowerHeap(int capacity) {
        this.capacity = capacity;
        a = new int[capacity + 1];
    }

    public void insert(int data) {
        if (count == capacity) {
            return;
        }
        ++count;
        a[count] = data;

        int i = count;

        while (i/2>0 && a[i] < a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }

    public boolean isFull(){
        return count == capacity;
    }

    public int getMin(){
        if (count == 0){
            return -1;
        }else{
            return a[1];
        }
    }

    public int removeMin() {
        if (count <= 0) {
            return -1;
        }
        int result = a[1];
        a[1] = a[count];
        --count;

        heapify(a, count, 1);
        return result;
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i <= n) {
                if (a[i] > a[2 * i]) {
                    minPos = 2 * i;
                }
            }
            if (2 * i + 1 <= n) {
                if (a[minPos] > a[2 * i + 1]) {
                    minPos = 2 * i + 1;
                }
            }
            if (i == minPos) {
                break;
            }
            swap(a, minPos, i);
            i = minPos;
        }
    }

    private void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
