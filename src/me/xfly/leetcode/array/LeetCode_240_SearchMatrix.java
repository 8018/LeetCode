package me.xfly.leetcode.array;

public class LeetCode_240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = 0;

        while (row>=0 && column < matrix[0].length){
            if (matrix[row][column] < target) {
                column++;
            } else if (matrix[row][column] > target) {
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

}