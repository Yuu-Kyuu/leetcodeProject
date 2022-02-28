package com.leetcode.p11;

public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int lIndex = 0, rIndex = height.length - 1;
        while (lIndex != rIndex) {
            result = height[lIndex] < height[rIndex] ?
                    Math.max(result, (rIndex - lIndex) * height[lIndex++]) :
                    Math.max(result, (rIndex - lIndex) * height[rIndex--]);
        }
        return result;
    }
}