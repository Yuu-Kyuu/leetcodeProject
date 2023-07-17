
package com.leetcode.daily.p2283;

import java.util.HashMap;

class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer, Integer> numCount = new HashMap<>(num.length());
        for (char c : num.toCharArray()) {
            numCount.put(c - 48, numCount.getOrDefault(c - 48, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i) - 48) != numCount.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        new Solution().digitCount("1210");
    }
}