package com.leetcode.dp.p10offer;

class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        int resultN = 1;
        int resultN_1 = 0;
        int tmp = 0;

        for (int i = 2; i <= n; i++) {
            tmp = resultN_1;
            resultN_1 = resultN;
            resultN = resultN + tmp;
            if (resultN > 1000000007) {
                resultN = resultN % 1000000007;
            }
        }
        return resultN;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(50));
        System.out.println(new Solution().fib(100));
        System.out.println(new Solution().fib(101));
        System.out.println(new Solution().fib(102));
        System.out.println(new Solution().fib(103));
    }
}