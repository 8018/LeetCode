package me.xfly.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_964 {

    public static void main(String[] args) {
        LeetCode_964 leetCode_964 = new LeetCode_964();
        System.out.println(leetCode_964.leastOpsExpressTarget(3,19));
    }

    Map<String, Integer> memo;
    int x;
    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap();
        this.x = x;
        return dp(0, target) - 1;
    }

    public int dp(int i, int target) {
        String code = "" + i + "#" + target;
        if (memo.containsKey(code))
            return memo.get(code);

        int ans;
        if (target == 0) {
            ans = 0;
        } else if (target == 1) {
            ans = cost(i);
        } else if (i >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(i) + dp(i+1, t),
                    (x-r) * cost(i) + dp(i+1, t+1));
        }

        memo.put(code, ans);
        return ans;
    }

    public int cost(int x) {
        return x > 0 ? x : 2;
    }
}
