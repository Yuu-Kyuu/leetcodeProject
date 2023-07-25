
package com.leetcode.daily.p771;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set<Character> hashSet = jewels.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        for (char c : stones.toCharArray()) {
            if (hashSet.contains(c)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("Aa", "dfgsaASAFASD"));
    }
}