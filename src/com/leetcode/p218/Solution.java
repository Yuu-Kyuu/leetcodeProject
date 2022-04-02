package com.leetcode.p218;

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> data = new ArrayList<>(buildings.length);
        for (int i = 0; i < buildings.length; i++) {
            data.add(new Event(buildings[i][0], buildings[i][2], 1, i));
            data.add(new Event(buildings[i][1], buildings[i][2], -1, i));
        }
        data.sort(Comparator.comparingInt(o -> o.pos));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        HashMap<Integer, Boolean> removed = new HashMap<>(data.size());
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Event e = data.get(i);
            if (e.type == 1) {
                q.add(new int[]{e.height, e.index});
            } else {
                removed.put(e.index, true);
            }
            if (i == data.size() - 1 || data.get(i).pos != data.get(i + 1).pos) {
                while (!q.isEmpty() && removed.getOrDefault(q.peek()[1], false)) {
                    q.poll();
                }
                int height = q.isEmpty() ? 0 : q.peek()[0];
                if (ans.isEmpty() || height != ans.get(ans.size() - 1).get(1)) {
                    ans.add(Arrays.asList(e.pos, height));
                }
            }
        }

        return ans;
    }

    class Event {
        int pos;
        int height;
        int type;
        int index;

        public Event(int pos, int height, int type, int index) {
            this.pos = pos;
            this.height = height;
            this.type = type;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        new Solution().getSkyline(new int[][]
                {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
    }
}