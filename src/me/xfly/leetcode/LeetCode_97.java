package me.xfly.leetcode;


public class LeetCode_97 {

    int[][] memo;
    String s1,s2,s3;

    public static void main(String[] args) {
        LeetCode_97 leetCode_97 = new LeetCode_97();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";

        System.out.println(String.valueOf(leetCode_97.isInterleaveWithDp(s1,s2,s3)));

    }

    public boolean isInterleaveWithDp(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1;i<=m && s1.charAt(i-1)==s3.charAt(i-1);i++) dp[i][0] = true;
        for (int j = 1;j<=n && s2.charAt(j-1)==s3.charAt(j-1);j++) dp[0][j] = true;

        for (int i = 1;i<=m;i++){
            for (int j = 1;j<=n;j++){
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));

            }
        }

        return dp[m][n];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new int[s1.length()+1][s2.length()+1];

        return dfs(0,0,0);
    }

    private boolean dfs(int i,int j,int k){
        if (memo[i][j] != 0) return memo[i][j] ==1?true:false;

        if (k == s3.length()){
            memo[i][j] = 1;
            return true;
        }
        boolean isValid = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isValid = dfs(i + 1, j, k + 1);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isValid = isValid || dfs(i, j + 1, k + 1);
        }

        if (isValid){
            memo[i][j] = 1;
        }else{
            memo[i][j] = 2;
        }
        return isValid;
    }


}
