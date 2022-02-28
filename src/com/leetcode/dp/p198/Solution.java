package com.leetcode.dp.p198;


import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length + 1;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[n];
    }


    public static void main(String[] args) {
        new Solution().rob(new int[]{1, 2, 3, 1});
    }
}