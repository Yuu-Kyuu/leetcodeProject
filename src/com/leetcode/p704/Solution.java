package com.leetcode.p704;

class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
    }
}