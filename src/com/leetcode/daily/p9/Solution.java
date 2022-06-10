
package com.leetcode.daily.p9;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> nums = new ArrayList<>();
        while (x > 0) {
            nums.add(x % 10);
            x = x / 10;
        }

        while (!nums.isEmpty()) {
            if (nums.size() <= 1) {
                break;
            }
            if (!nums.remove(nums.size() - 1).equals(nums.remove(0))) {
                return false;
            }
        }
        return true;
    }
}