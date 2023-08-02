
package com.leetcode.daily.p822;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    // public int flipgame(int[] fronts, int[] backs) {
    //     PriorityQueue<Integer> stack = new PriorityQueue<>(fronts.length * 2, (a, b) -> a - b);
    //     HashSet<Integer> sameFrontAndBack = new HashSet<>(fronts.length);
    //     for (int i = 0; i < backs.length; i++) {
    //         if (fronts[i] == backs[i]) {
    //             sameFrontAndBack.add(fronts[i]);
    //             stack.remove(fronts[i]);
    //         } else {
    //             if (!sameFrontAndBack.contains(fronts[i]) && !stack.contains(fronts[i]))
    //                 stack.add(fronts[i]);
    //             if (!sameFrontAndBack.contains(backs[i]) && !stack.contains(backs[i]))
    //                 stack.add(backs[i]);
    //         }
    //     }
    //     return stack.isEmpty() ? 0 : stack.peek();
    // }

    public int flipgame(int[] fronts, int[] backs) {
        PriorityQueue<Integer> stack = new PriorityQueue<>(fronts.length * 2, (a, b) -> a - b);
        HashSet<Integer> sameFrontAndBack = new HashSet<>(fronts.length);
        for (int i = 0; i < backs.length; i++) {
            if (fronts[i] == backs[i]) {
                sameFrontAndBack.add(fronts[i]);
            } else {
        
                    stack.add(fronts[i]);

                    stack.add(backs[i]);
            }
        }
      
            stack.removeAll(sameFrontAndBack);
        
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().flipgame(new int[] { 2, 2, 2, 2, 1 }, new int[] { 2, 1, 2, 1, 1 }));
    }
}