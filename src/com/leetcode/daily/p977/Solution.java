
package com.leetcode.daily.p977;

import java.util.LinkedList;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        LinkedList<Integer> negativeNums = new LinkedList<>();
        int currentNegativeSquare = 0;
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeNums.add(nums[i]);
            } else {
                int currentSquare = square(nums[i]);
                while (!negativeNums.isEmpty()) {
                    if (currentNegativeSquare == 0) {
                        currentNegativeSquare = square(negativeNums.pollLast());
                    }

                    if (currentNegativeSquare <= currentSquare) {
                        result[currentIndex++] = currentNegativeSquare;
                        currentNegativeSquare = square(negativeNums.pollLast());
                    } else {
                        break;
                    }
                }

                if (currentNegativeSquare > 0 && currentNegativeSquare <= currentSquare) {
                    result[currentIndex++] = currentNegativeSquare;
                    currentNegativeSquare = 0;
                }

                result[currentIndex++] = currentSquare;
            }

        }

        if (currentIndex < nums.length) {
            if (currentNegativeSquare > 0) {
                result[currentIndex++] = currentNegativeSquare;
            }
            while (!negativeNums.isEmpty()) {
                result[currentIndex++] = square(negativeNums.pollLast());
            }
        }

        return result;
    }

    public static int square(Integer x) {
        return x == null ? 0 : x * x;
    }

    public static void main(String[] args) {
        //new Solution().sortedSquares(new int[]{-4, -1, 0, 3, 10});
        //new Solution().sortedSquares(new int[]{-7, -3, 2, 3, 11});
        //new Solution().sortedSquares(new int[]{-2, 0});
        new Solution().sortedSquares(new int[]{-4, -2, 0, 1});
    }
}