package com.leetcode.p191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if ((n & 2) == 1) {
                ans++;
            }
            n = n >>> 1;
        }
        return ans;

    }
}