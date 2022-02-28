package com.leetcode.dp.p45;

class Solution {
    public int jump(int[] nums) {
        int result = 0, maxPosition = 0, currentIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == currentIndex) {
                currentIndex = maxPosition;
                result++;
            }
        }
        return result;
    }
}