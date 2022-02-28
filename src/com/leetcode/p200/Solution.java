package com.leetcode.p200;


class Solution {
    int[][] used;

    public int numIslands(char[][] grid) {
        int result = 0;
        used = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (used[i][j] == 1) {
                    continue;
                }
                if (grid[i][j] == '1' && used[i][j] == 0) {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }


        return result;
    }

    private void bfs(char[][] grid, int i, int j) {
        System.out.println(i + "//" + j + "//" + grid[i][j]);
        if (i >= used.length || j >= used[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }
        used[i][j] = 1;
        bfs(grid, i + 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i - 1, j);
        bfs(grid, i, j - 1);
    }
}