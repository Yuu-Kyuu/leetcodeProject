package com.leetcode.p1;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> data = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (data.get(target - nums[i]) != null) {
                result[0] = i;
                result[1] = data.get(target - nums[i]);
                break;
            } else {
                data.put(target - nums[i], i);
            }
        }
        return result;
    }
}