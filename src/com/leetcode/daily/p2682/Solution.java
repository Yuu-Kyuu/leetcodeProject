
package com.leetcode.daily.p2682;

import java.util.HashSet;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> getBallNum = new HashSet<>(n);
        int current = 0;
        for (int i = 1; i < k * n + 1; i++) {
            if (!getBallNum.contains(current + 1)) {
                getBallNum.add(current + 1);
                current = (current + i * k) % n;
            } else {
                break;
            }
        }

        int[] result = new int[n - getBallNum.size()];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (!getBallNum.contains(i)) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().circularGameLosers(1, 1);
    }
}