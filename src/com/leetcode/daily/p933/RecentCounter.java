package com.leetcode.daily.p933;

import java.util.ArrayList;
import java.util.List;

class RecentCounter {

    private List<Integer> pingData;
    private int currentIndex;

    public RecentCounter() {
        pingData = new ArrayList<>(10);
        currentIndex = 0;
    }

    public int ping(int t) {
        pingData.add(t);
        while (pingData.get(currentIndex) < t - 3000) {
            currentIndex++;
        }
        return pingData.size() - currentIndex;
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */