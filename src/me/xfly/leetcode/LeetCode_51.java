package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51 {

    public static void main(String[] args) {
        new LeetCode_51().solveNQueens(8);
    }

    int[] result;

    public List<List<String>> solveNQueens(int n) {
        result = new int[n];
        List<List<String>> list = new ArrayList<>();

        calNQueues(n, 0, list);

        return list;
    }

    public void calNQueues(int n, int row, List<List<String>> list) {
        if (row == n) {
            list.add(getResult(result));
        }

        for (int i = 0;i<n;i++){
            //能放，放入当前位置
            //不能则进入下一列
            if (isOk(row,i)){
                result[row]=i;
                calNQueues(n,row+1,list);
            }
        }
        //如果本行的所有位置都不能放，相当于出栈回溯
    }

    public List<String> getResult(int[] result) {
        List<String> list = new ArrayList<String>();
        for (int row = 0; row < result.length; ++row) {
            String temp = "";
            for (int column = 0; column < result.length; ++column) {
                if (result[row] == column)
                    temp += "Q";
                else
                    temp += ".";
            }
            System.out.println(temp);
            list.add(temp);
        }
        System.out.println();

        return list;
    }

    /**
     * 判断当前位置是否能放置
     * 左上、右上和正上方不能有棋子
     * */
    boolean isOk(int m, int n) {
        //左上
        int leftUp = n - 1;
        //右上
        int rightUp = n + 1;


        for (int i = m - 1; i >= 0; i--) {
            if (result[i] == n) {
                return false;
            }

            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            if (rightUp < result.length) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

}
