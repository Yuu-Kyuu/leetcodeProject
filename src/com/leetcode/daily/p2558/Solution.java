
package com.leetcode.daily.p2558;

import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        long result = 0;
        PriorityQueue<Integer> stack = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int g : gifts) {
            stack.offer(g);
        }
        for (int i = 0; i < k; i++) {
            stack.offer((int) Math.sqrt(stack.poll()));
        }
        for (Integer remain : stack) {
            result = result + remain.longValue();
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().pickGifts(new int[] { 25, 64, 9, 4, 100 }, 4);
    }
}