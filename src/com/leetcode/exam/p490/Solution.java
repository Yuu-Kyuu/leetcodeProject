package com.leetcode.exam.p490;

import java.util.Arrays;

class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int[][] maze;
    int[] destination;

    int row, column;
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        this.destination = destination;
        this.maze = maze;
        this.row = maze.length;
        this.column = maze[0].length;
        this.visited = new boolean[row][column];


        visited[start[0]][start[1]] = true;
        for (int[] direction : directions) {
            if (dfs(start, direction)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int[] start, int[] direction) {
//        System.out.println(Arrays.toString(start));
        int[] moveEnd = moveForward(start, direction);
//        System.out.println(Arrays.toString(moveEnd));
        if (start[0] == moveEnd[0] && start[1] == moveEnd[1]) {
            //cant move forward
            return false;
        }
        if (moveEnd[0] == destination[0] && moveEnd[1] == destination[1]) {
            return true;
        }

        if (visited[moveEnd[0]][moveEnd[1]]) {
            return false;
        } else {
            visited[moveEnd[0]][moveEnd[1]] = true;
        }

        for (int[] nextDir : directions) {
            if (dfs(Arrays.copyOf(moveEnd, 2), nextDir)) {
                return true;
            }
        }


        return false;
    }

    private int[] moveForward(int[] start, int[] direction) {
        int[] end = Arrays.copyOf(start, 2);
        while (end[0] + direction[0] >= 0 && end[0] + direction[0] < row
                && end[1] + direction[1] >= 0 && end[1] + direction[1] < column
                && maze[end[0] + direction[0]][end[1] + direction[1]] == 0) {
            end[0] += direction[0];
            end[1] += direction[1];
        }
        return end;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().hasPath(
//                new int[][]{{0, 0, 0, 0, 0},
//                        {1, 1, 0, 0, 1},
//                        {0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 1},
//                        {0, 1, 0, 0, 0}},
//                new int[]{3, 4},
//                new int[]{0, 1}));

        System.out.println(new Solution().hasPath(
                new int[][]{{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}},
                new int[]{0, 4},
                new int[]{4, 4}));
    }
}