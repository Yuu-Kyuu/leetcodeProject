
package com.leetcode.daily.p1700;

import java.util.Arrays;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int remain1 = Arrays.stream(students).sum();
        int remain0 = students.length - remain1;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && remain0 > 0) {
                remain0--;
            } else if (sandwich == 1 && remain1 > 0) {
                remain1--;
            } else {
                break;
            }
        }
        return remain0 + remain1;
    }

    public static void main(String[] args) {
        new Solution().countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
    }
}