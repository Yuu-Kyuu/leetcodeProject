package com.leetcode.p433;

import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        List<String> bankSet = Arrays.asList(bank);
        LinkedList<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>(bank.length * 2);
        String[] gene = {"A", "T", "C", "G"};
        queue.add(start);
        map.put(start, 0);
        while (!queue.isEmpty()) {
            String changeStart = queue.poll();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (String.valueOf(changeStart.charAt(i)).equals(gene[j])) {
                        continue;
                    }
                    String changeEnd = changeStart.substring(0, i) + gene[j] + changeStart.substring(i + 1, changeStart.length());
                    if (!bankSet.contains(changeEnd)) {
                        continue;
                    }
                    if (!map.containsKey(changeEnd)) {
                        map.put(changeEnd, map.get(changeStart) + 1);
                        queue.add(changeEnd);
                        if (changeEnd.equals(end)) {
                            return map.get(changeEnd);
                        }
                    }
                }
            }
        }
        return -1;
    }
}