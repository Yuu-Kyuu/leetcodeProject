
package com.leetcode.daily.p599;

import java.util.HashMap;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> list1Map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }
        String ans = "";
        int ansIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (list1Map.containsKey(list2[i])) {
                if (ansIndexSum == list1Map.get(list2[i]) + i) {
                    ans = ans + "," + list2[i];
                    continue;
                }
                if (ansIndexSum > list1Map.get(list2[i]) + i) {
                    ans = list2[i];
                    ansIndexSum = list1Map.get(list2[i]) + i;
                }
            }
        }
        return ans.split(",");
    }

    public static void main(String[] args) {
        new Solution().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
    }
}