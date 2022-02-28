package com.leetcode.dp.p122;

class Solution {
//    public int maxProfit(int[] prices) {
//        int result = 0;
//        int isHold = -1;
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i] < prices[i + 1]) {
//                //if prices is up and not hold stock,buy it
//                if (isHold == -1) {
//                    isHold = i;
//                }
//                //else do nothing
//            } else {
//                //if prices is down and  holding stock,sell it
//                if (isHold > -1) {
//                    result = result + prices[i] - prices[isHold];
//                    isHold = -1;
//                }
//                //else do nothing
//            }
//        }
//        //last day
//        if (isHold > -1) {
//            result = result + prices[prices.length - 1] - prices[isHold];
//        }
//
//        return result;
//    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}