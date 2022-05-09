package com.leetcode.p6;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int rowIndex = 0;
        int step = -1;
        for (char c : s.toCharArray()) {

            stringBuilders[rowIndex].append(c);
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                step = -step;
            }
            rowIndex += step;
        }

        for (int i = 1; i < numRows; i++) {
            stringBuilders[0].append(stringBuilders[i]);
        }

        return stringBuilders[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}