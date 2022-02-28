package com.leetcode.p162;

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int lmid = (left + right) / 2;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid]) {
                left = lmid + 1;
            } else {
                right = rmid - 1;
            }
        }
        return right;
    }
}