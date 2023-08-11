package com.leetcode.daily.p1572;

class Solution {
    public int diagonalSum(int[][] mat) {
        if (mat.length == 1)
            return mat[0][0];
        int n = mat.length;
        int reslut = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i == j || i + j == n - 1) {
                    reslut += mat[i][j];
                }
            }
        }
        return reslut;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
    }
}