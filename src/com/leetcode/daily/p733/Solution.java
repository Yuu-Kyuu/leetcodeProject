
package com.leetcode.daily.p733;

class Solution {
    static int initColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        initColor = image[sr][sc];
        bfs(image, sr, sc, color);
        return image;
    }

    private static void bfs(int[][] image, int x, int y, int color) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != initColor || image[x][y] == color) {
            return;
        }
        image[x][y] = color;
        bfs(image, x - 1, y, color);
        bfs(image, x + 1, y, color);
        bfs(image, x, y - 1, color);
        bfs(image, x, y + 1, color);
    }
}