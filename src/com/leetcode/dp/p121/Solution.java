package com.leetcode.dp.p121;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int[] dp = new int[n];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }


    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }


}