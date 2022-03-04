package com.leetcode.dp.p680;


class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return validPalindromeSubStr(s.substring(l + 1, r + 1)) || validPalindromeSubStr(s.substring(l, r));
            }
        }
        return true;
    }

    public boolean validPalindromeSubStr(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int l = -1, r = s.length();
        while (l++ <= r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abc"));
        System.out.println(new Solution().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

}

