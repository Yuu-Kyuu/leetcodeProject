package com.leetcode.p50;

class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0d) return x;
        return n >= 0 ? subPow(x, n) : 1.0 / subPow(x, -(long)n);
    }

    double subPow(double x, long n) {
        double ans = 1.0;
        double xPow = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xPow;
            }
            xPow *= xPow;
            n /= 2;
        }
        return ans;
    }
}
