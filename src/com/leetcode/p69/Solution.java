package com.leetcode.p69;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int result = -1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(1));
    }
}