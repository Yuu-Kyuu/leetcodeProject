package com.leetcode.tree.p337;

import com.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> dpChoose = new HashMap<>();
    Map<TreeNode, Integer> dpNotChoose = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(dpChoose.getOrDefault(root, 0),
                dpNotChoose.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        dpChoose.put(node, node.val + dpNotChoose.getOrDefault(node.left, 0) + dpNotChoose.getOrDefault(node.right, 0));
        dpNotChoose.put(node, Math.max(dpChoose.getOrDefault(node.left, 0),
                dpNotChoose.getOrDefault(node.left, 0)) + Math.max(dpChoose.getOrDefault(node.right, 0), dpNotChoose.getOrDefault(node.right, 0)));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new TreeNode(1,
                new TreeNode(2), new TreeNode(3))));
    }
}