
package com.leetcode.daily.p557;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
                ans.append(' ');
            } else {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }
        }

        return ans.toString();
    }
}