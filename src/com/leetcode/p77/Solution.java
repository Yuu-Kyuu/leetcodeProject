package com.leetcode.p77;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, path, res);
        return res;
    }

    private void dfs(int n, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = n; i > 0; i--) {
            path.addLast(i);
            dfs(i - 1, k, path, res);
            path.removeLast();
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}