package com.leetcode.p49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>(strs.length);
        for (String s : strs) {
            char[] keyChar = s.toCharArray();
            Arrays.sort(keyChar);
            String key = Arrays.toString(keyChar);
            List<String> anagramsData = anagrams.getOrDefault(key, new LinkedList<>());
            anagramsData.add(s);
            anagrams.put(key, anagramsData);
        }
        return new ArrayList<>(anagrams.values());
    }
}