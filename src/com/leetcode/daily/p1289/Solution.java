package com.leetcode.daily.p1289;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return grid[0][0];

        int[][] dp = new int[n][n];
        dp[0] = Arrays.copyOf(grid[0], n);
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], 20000);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }

        int result = 20000;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
    }
}