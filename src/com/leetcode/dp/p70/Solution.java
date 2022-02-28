package com.leetcode.dp.p70;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> climbedStairs = new HashMap<>();
    public int climbStairs(int n) {
        if (n < 3) return n;
        if (climbedStairs.get(n) == null)
            climbedStairs.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return climbedStairs.get(n);
    }
}