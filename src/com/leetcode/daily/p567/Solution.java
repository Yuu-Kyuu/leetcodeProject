
package com.leetcode.daily.p567;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] hashs1 = new int[26];
        for (char c : s1.toCharArray()) {
            hashs1[c - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int[] hashAns = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                hashAns[s2.charAt(j) - 'a']++;
            }
            System.out.println(Arrays.toString(hashAns));
            if (Arrays.equals(hashs1, hashAns)) {
                return true;
            }
        }

        return false;
    }
}