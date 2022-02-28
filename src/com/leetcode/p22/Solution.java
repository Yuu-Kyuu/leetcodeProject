package com.leetcode.p22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> answer;
    int parenthesisLength = 0;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        parenthesisLength = n;
        backtrack("", 0, 0);
        return answer;
    }

    public void backtrack(String str, int left, int right) {
        if (str.length() == parenthesisLength + parenthesisLength) {
            answer.add(str);
            return;
        }
        if (left < parenthesisLength)
            backtrack(str + "(", left + 1, right);
        if (right < left)
            backtrack(str + ")", left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
