
package com.leetcode.daily.P2208;

import java.util.PriorityQueue;

class Solution {
    public int halveArray(int[] nums) {
        int result = 0;
        double sum = 0.0d;
        double current = 0.0d;
        PriorityQueue<Double> stack = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            stack.add((double) num);
            sum = sum + num;
        }
        sum = sum / 2;

        while (sum > 0) {
            if (current < stack.peek()) {
                stack.add(current);
                current = stack.poll() / 2;
            } else {
                current = current / 2;
            }
            sum = sum - current;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().halveArray(new int[] { 5, 19, 8, 1 }));
         System.out.println(new Solution().halveArray(new int[] {6,58,10,84,35,8,22,64,1,78,86,71,77 }));
    }
}