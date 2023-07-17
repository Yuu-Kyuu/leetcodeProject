package com.leetcode.daily.p1221;

class Solution {
    public int balancedStringSplit(String s) {
        int numL = 0;
        int numR = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') numL++;
            if (c == 'R') numR++;
            if (numL == numR) {
                numL = 0;
                numR = 0;
                ans++;
            }
        }
        return ans;
    }
}
