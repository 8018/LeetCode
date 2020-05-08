package me.xfly.leetcode;

public class LeetCode_322 {
    public static void main(String[] args) {
        int[] coins = {11,5,2};
        coinChange(coins,15);
    }

    public static int coinChange(int[] coins, int amount) {
        int [] f = new int[amount + 1];
        f[0] = 0;

        for(int i = 1; i <= amount; i++){

            int cost = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }

            f[i] = cost;
        }

        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];

    }

   /* private static int coinChangeByFlashBack(int ,int[] coins,int amount){

    }*/

}
