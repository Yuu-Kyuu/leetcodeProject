
package com.leetcode.daily.p189;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
            if (k == 0) {
                return;
            }
        }
        int[] rotateNums = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rotateNums, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}