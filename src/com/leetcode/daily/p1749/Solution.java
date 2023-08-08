
package com.leetcode.daily.p1749;

class Solution {

    public int maxAbsoluteSum(int[] nums) {
        // dp[i]=max{nums[i],dp[i−1]+nums[i]}
        if (nums.length == 1) {
            return Math.abs(nums[0]);
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int min = nums[0], max = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], dpMax[i - 1] + nums[i]);
            dpMin[i] = Math.min(nums[i], dpMin[i - 1] + nums[i]);
            min = Math.min(dpMin[i], min);
            max = Math.max(dpMax[i], max);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().maxAbsoluteSum(new int[] { 2, -5, 1, -4, 3, -2 }));
        System.out.println(new Solution().maxAbsoluteSum(new int[] { 2, -1 }));
    }
}