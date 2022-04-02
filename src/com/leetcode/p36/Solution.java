package com.leetcode.p36;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        List<Set<Character>> rows = new ArrayList<>(n);
        List<Set<Character>> columns = new ArrayList<>(n);
        List<Set<Character>> box = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>(9));
            columns.add(new HashSet<>(9));
            box.add(new HashSet<>(9));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!rows.get(i).add(ch)) {
                        return false;
                    }
                    if (!columns.get(j).add(ch)) {
                        return false;
                    }
                    if (!box.get(i / 3 * 3 + j / 3).add(ch)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isValidSudoku(new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        );
    }
}