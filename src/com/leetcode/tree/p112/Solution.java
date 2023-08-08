package com.leetcode.tree.p112;

import com.leetcode.tree.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasPathSum(new TreeNode(5, new TreeNode(1), new TreeNode(4,
                new TreeNode(3), new TreeNode(6))), 6));
    }
}