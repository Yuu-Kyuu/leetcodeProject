package com.leetcode.p51;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<List<String>> result = new ArrayList<>();
    HashMap<Integer, Boolean> usedColumn;
    HashMap<Integer, Boolean> usedPie;
    HashMap<Integer, Boolean> usedNa;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        usedColumn = new HashMap<>(n);
        usedPie = new HashMap<>(n);
        usedNa = new HashMap<>(n);
        int[][] board = new int[n][n];
        backtrack(n, board, 0);
        return result;
    }

    public void backtrack(int n, int[][] board, int row) {
        if (row == n) {
            result.add(board2Result(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) {
                continue;
            }
            board[row][col] = 1;
            usedColumn.put(col, true);
            usedPie.put(row + col, true);
            usedNa.put(row - col, true);
            backtrack(n, board, row + 1);
            usedColumn.put(col, false);
            usedPie.put(row + col, false);
            usedNa.put(row - col, false);
            board[row][col] = 0;
        }
    }

    public boolean isValid(int row, int col) {
        boolean used = usedColumn.getOrDefault(col, false) ||
                usedPie.getOrDefault(row + col, false) ||
                usedNa.getOrDefault(row - col, false);
        return !used;
    }

    public List<String> board2Result(int[][] board) {
        List<String> list = new ArrayList<>();
        for (int[] row : board) {
            StringBuilder rowStr = new StringBuilder();
            for (int p : row) {
                rowStr.append(p == 0 ? "." : "Q");
            }
            list.add(rowStr.toString());
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(5));
    }
}
