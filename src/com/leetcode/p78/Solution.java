package com.leetcode.p78;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            result.addAll(preSubSets(result, nums[i]));
            System.out.println(result);
        }
        return result;
    }

    List<List<Integer>> preSubSets(List<List<Integer>> presubs, int newNum) {
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> presub : presubs) {
            LinkedList<Integer> newPre = new LinkedList<>(presub);
            newPre.add(newNum);
            result.add(newPre);
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1, 2, 3});
    }
}
