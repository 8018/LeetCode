package me.xfly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*class Solution {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Solution solution = new Solution();
        solution.solveSudoku(board);
        solution.printBoard(board);

    }

    // box size
    int n = 3;
    // row size
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {

    //Check if one could place a number d in (row, col) cell

        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {

    //Place a number d in (row, col) cell

        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int row, int col) {

    //Remove a number which didn't lead to a solution

        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {

   *//* Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution*//*

        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {

    //Backtracking

        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        }
        else placeNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    private void printBoard(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if ((j+1)%3==0){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}*/



public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        char[][] board2 = new char[9][9];
        helper(board,board2,0,0);
    }

    public static void helper(char[][] board,char[][] board2,int m,int n){
        if (m >=9){
            printBoard(board2);
            return;
        }
        if (n >=9){
            helper(board,board2,m+1,0);
        }else{
            if (board[m][n] != '.'){
                board2[m][n] = board[m][n];
                helper(board,board2,m,n+1);
            }else{
                char[] avalible = getAvalibleChars(board,m,n);

                for (int i = 0;i<9;i++){
                    if (avalible[i]!='.'){
                        if (isOk(board2,m,n,avalible[i])){
                            board2[m][n] = avalible[i];
                            helper(board,board2,m,n+1);
                        }
                    }
                }
            }



            if (board[m][n] == '.'){
                board2[m][n] = '.';
            }
        }


    }

    private static void printBoard(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if ((j+1)%3==0){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    private static boolean isOk(char[][] board, int m, int n, char c) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[m][i] == c) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][n] == c) {
                return false;
            }
        }

        int left = n / 3 * 3;
        int right = left + 2;

        int top = m / 3 * 3;
        int bottom = top + 2;

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if ((board[i][j]) == c) {
                    return false;
                }
            }
        }

        return true;
    }

    private static char[] getAvalibleChars(char[][] board, int m, int n) {
        char[] avalible = {'1','2','3','4','5','6','7','8','9'};

        for (int i = 0; i < board[0].length; i++) {
            if (board[m][i] != '.') {
                avalible[Integer.valueOf(board[m][i])-49] = '.';
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][n] != '.') {
                avalible[Integer.valueOf(board[i][n])-49] = '.';
            }
        }

        int left = n / 3 * 3;
        int right = left + 2;

        int top = m / 3 * 3;
        int bottom = top + 2;

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if ((board[i][j]) != '.') {
                    avalible[Integer.valueOf(board[i][j])-49] = '.';
                }
            }
        }

        return avalible;
    }
}
