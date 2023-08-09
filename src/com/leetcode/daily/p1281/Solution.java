package com.leetcode.daily.p1281;

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 0;
        int sum = 0;
        while (n != 0) {
            product *= n % 10;
            sum += n % 10;
            n = n / 10;
        }
        return product - sum;
    }
}