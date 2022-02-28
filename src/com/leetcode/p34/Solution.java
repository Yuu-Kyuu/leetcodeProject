package com.leetcode.p34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStarting(nums, target);
        result[1] = findEnding(nums, target, result[0]);
        return result;
    }

    private int findStarting(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    private int findEnding(int[] nums, int target, int start) {
        if (start == -1) {
            return -1;
        }
        int index = -1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10}, 8));
    }
}
