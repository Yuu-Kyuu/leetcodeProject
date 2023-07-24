
package com.leetcode.daily.p918;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int preMax = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            result = Math.max(result, preMax);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        int rightSum = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            rightSum += nums[i];
            result = Math.max(result, rightSum + leftMax[i - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[] { 10, 2, -5 }));
    }
}