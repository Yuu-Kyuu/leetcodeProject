
package com.leetcode.daily.p283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int currentNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[currentNonZeroIndex] = nums[i];
                currentNonZeroIndex++;
            }
        }
        int[] remain = new int[nums.length - currentNonZeroIndex];
        System.arraycopy(remain, 0, nums, currentNonZeroIndex, remain.length);
        System.out.println(Arrays.toString(nums));
    }
}