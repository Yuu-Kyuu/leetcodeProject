package com.leetcode.p942;

class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int max = s.length();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        result[s.length()] = min;
        return result;
    }
}