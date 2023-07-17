
package com.leetcode.daily.p946;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int pushedInt : pushed) {
            if (pushedInt == popped[poppedIndex]) {
                poppedIndex++;
                while (!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                    poppedIndex++;
                    stack.pop();
                }
            } else {
                stack.push(pushedInt);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
    }
}