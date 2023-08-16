
package com.leetcode.daily.p833;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        HashMap<Integer, Integer> ops = new HashMap<>();

        for (int i = 0; i < targets.length; i++) {
            if (indices[i] + sources[i].length() < s.length()
                    && s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
                ops.put(indices[i], i);
            }
        }

        int[] sortedIndex = Arrays.copyOf(indices, indices.length);
        Arrays.sort(sortedIndex, 0, sortedIndex.length);

        int indexDiff = 0;
        for (int i = 0; i < indices.length; i++) {
            if (ops.containsKey(sortedIndex[i])) {
                int trueIndex = ops.get(sortedIndex[i]);
                sb.delete(indices[trueIndex] + indexDiff, indices[trueIndex] + indexDiff + sources[trueIndex].length());
                sb.insert(indices[trueIndex] + indexDiff, targets[trueIndex]);
                indexDiff += targets[trueIndex].length() - sources[trueIndex].length();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findReplaceString("abcde", new int[] { 2, 2 }, new String[] { "cdef", "bc" },
                new String[] { "f", "fe" }));
    }
}