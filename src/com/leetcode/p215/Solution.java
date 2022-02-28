package com.leetcode.p215;

import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int start, int end, int index) {
        if (start >= end) {
            return nums[start];
        }
        int pivot = partition(nums, start, end);
        if (index <= pivot) {
            return quickSort(nums, start, pivot, index);
        } else {
            return quickSort(nums, pivot + 1, end, index);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int poivt = start + new Random().nextInt(nums.length) % (end - start + 1);
        int povitVal = nums[poivt];
        while (start <= end) {
            while (nums[start] < povitVal) {
                start++;
            }
            while (nums[end] > povitVal) {
                end--;
            }
            if (start == end) {
                break;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
        return end;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}