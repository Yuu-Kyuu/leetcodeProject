
package com.leetcode.dp.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        int reslut = Integer.MIN_VALUE;
        int preSum = 0;
        for (int num : nums) {
            preSum = Integer.max(preSum + num, num);
            reslut = Integer.max(preSum, reslut);
        }
        return reslut;
    }
}
