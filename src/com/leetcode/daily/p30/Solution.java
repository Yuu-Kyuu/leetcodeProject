
package com.leetcode.daily.p30;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length() && i != -1) {
            int answer = s.indexOf(words[0], i);
            if (answer > 0) {
                for (String word : words) {

                    i = s.indexOf(word);
                }

            }
        }

        return ans;
    }
}