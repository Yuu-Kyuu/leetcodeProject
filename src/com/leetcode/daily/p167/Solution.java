
package com.leetcode.daily.p167;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int rightIndex = numbers.length - 1;
        int leftIndex;
        for (leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
            while (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            }

            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}