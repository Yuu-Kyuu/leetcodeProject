package com.leetcode.p125;

class Solution {
    char[] data;
    int l = 0;
    int r;

    public boolean isPalindrome(String s) {
        data = s.toCharArray();
        r = s.length() - 1;
        while (l <= r) {
            if (getPreChar() != getNextChar()) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private char getPreChar() {
        while (!Character.isDigit(data[r]) && !Character.isAlphabetic(data[r])) {
            if (r > 0) {
                r--;
            } else {
                return '-';
            }
        }
        System.out.println("r:" + data[r]);
        return Character.toLowerCase(data[r]);
    }

    private char getNextChar() {
        while (!Character.isDigit(data[l]) && !Character.isAlphabetic(data[l])) {
            if (l < data.length - 1) {
                l++;
            } else {
                return '-';
            }
        }
        System.out.println("l:" + data[l]);
        return Character.toLowerCase(data[l]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(".,"));
    }

}