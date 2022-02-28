package com.leetcode.dp.p300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}