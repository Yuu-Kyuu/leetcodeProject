package com.leetcode.dp.p152;


class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int currentMax = max, currentMin = min;
            max = Math.max(currentMax * nums[i], Math.max(nums[i], currentMin * nums[i]));
            min = Math.min(currentMin * nums[i], Math.min(nums[i], currentMax * nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }


}