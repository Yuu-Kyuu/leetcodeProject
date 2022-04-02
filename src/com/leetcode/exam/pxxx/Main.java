package com.leetcode.exam.pxxx;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] towerHeight = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            towerHeight[i] = s.nextInt();
            preSum[i] = preSum[i - 1] + towerHeight[i];
        }
        s.close();

        //分组时上一组的高度，为了维护递增性
        int[] towerGroupHeight = new int[n + 1];
        towerGroupHeight[1] = towerHeight[1];
        //dp[n] 表示前n个塔最大的分组数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (preSum[i] - preSum[j] >= towerGroupHeight[j]) {
                    //分组+1
                    dp[i] = dp[j] + 1;
                    //分组的高度为前缀和的差
                    towerGroupHeight[i] = preSum[i] - preSum[j];
                    break;
                }

            }
        }

        System.out.println(n - dp[n]);
    }
}