
package com.leetcode.daily.p2500;

import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0;
        for (int[] is : grid) {
            Arrays.sort(is);
        }

        for (int i = 0; i < grid[0].length; i++) {
             int rowMax = 0;
            for (int j = 0; j < grid.length; j++) {
                rowMax = Integer.max(rowMax, grid[j][i]);
            }
            result =result+rowMax;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}});
    }
}