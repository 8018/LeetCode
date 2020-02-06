package me.xfly.leetcode;

public class LeetCode_37 {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        new LeetCode_37().solveSudoku(board);
    }

    char[][] board2 = new char[9][9];
    boolean isSolved = false;
    public  void solveSudoku(char[][] board) {

        helper(board,0,0);
        board = board2;
        printBoard(board);
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

    public  void helper(char[][] board,int m,int n){
        //到最后一层的下一层，说明解析成功
        if (m >=9){
            isSolved = true;
            return;
        }
        //换到下一行
        if (n >=9){
            helper(board,m+1,0);
        }else{
            //原来就有数字
            if (board[m][n] != '.'){
                board2[m][n] = board[m][n];
                //跳到下一个
                helper(board,m,n+1);
            }else{
                //获取可用的数字
                char[] avalible = getAvalibleChars(board,m,n);

                for (int i = 0;i<9;i++){
                    if (avalible[i]!='.'){
                        //可以放进去
                        if (isOk(board2,m,n,avalible[i])){
                            board2[m][n] = avalible[i];
                            helper(board,m,n+1);
                        }
                    }
                }
            }

            if (!isSolved){
                if (board[m][n] == '.'){
                    board2[m][n] = '.';
                }
            }
        }


    }


    private  boolean isOk(char[][] board, int m, int n, char c) {
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
