package com.leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        result.add(intervals[0]);
        int currentIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] current = result.get(currentIndex);
            if (intervals[i][0] <= current[1] && intervals[i][0] >= current[0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                result.add(intervals[i]);
                currentIndex++;
            }
        }
        int[][] resultArray = new int[result.size()][2];
        result.toArray(resultArray);
        return resultArray;
    }
}