package com.leetcode.exam.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int third = second + 1;
                int forth = nums.length - 1;

                while (third < forth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[forth];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
                        third++;
                        while (third < nums.length && nums[third - 1] == nums[third]) {
                            third++;
                        }
                        continue;
                    }

                    if (sum > target) {
                        forth--;
                    } else {
                        third++;
                    }
                }
            }
        }

        return result;
    }
}