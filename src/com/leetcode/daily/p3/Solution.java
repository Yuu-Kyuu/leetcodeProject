
package com.leetcode.daily.p3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>(s.length());
        int start = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (chars.contains(c)) {
                int newStart = s.indexOf(c, start) + 1;
                for (int i = start; i < newStart; i++) {
                    chars.remove(s.charAt(i));
                }
                start = newStart;
                chars.add(c);
            } else {
                chars.add(c);
            }
            ans = Math.max(chars.size(), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("dvdf");
    }
}