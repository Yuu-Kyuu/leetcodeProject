
package com.leetcode.daily.p695;

class Solution {
    static int[][] visited;
    static int rowNum, columnNum, currentMax, globalMax;

    public int maxAreaOfIsland(int[][] grid) {
        currentMax = 0;
        globalMax = 0;
        rowNum = grid.length;
        columnNum = grid[0].length;
        visited = new int[rowNum][columnNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                bfs(grid, i, j, grid[i][j] == 1);
            }
        }
        return Math.max(currentMax, globalMax);
    }

    private static void bfs(int[][] grid, int x, int y, boolean needClear) {
        if (x < 0 || y < 0 || x >= rowNum || y >= columnNum || visited[x][y] == 1) {
            return;
        }
        visited[x][y] = 1;
        if (grid[x][y] == 1) {
            currentMax++;
            bfs(grid, x - 1, y, false);
            bfs(grid, x + 1, y, false);
            bfs(grid, x, y - 1, false);
            bfs(grid, x, y + 1, false);
            if (needClear) {
                globalMax = Math.max(currentMax, globalMax);
                currentMax = 0;
            }
        }
    }
}