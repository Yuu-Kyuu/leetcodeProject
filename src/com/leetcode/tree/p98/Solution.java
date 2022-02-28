package com.leetcode.tree.p98;

import com.leetcode.tree.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTSub(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTSub(TreeNode subRoot, long min, long max) {

        if (subRoot.left == null && subRoot.right == null) {
            return subRoot.val < max && subRoot.val > min;
        }

        if (subRoot.left == null) {
            return subRoot.val > min && subRoot.val < max && isValidBSTSub(subRoot.right, subRoot.val, max);
        }
        if (subRoot.right == null) {
            return subRoot.val > min && subRoot.val < max && isValidBSTSub(subRoot.left, min, subRoot.val);
        }
        return isValidBSTSub(subRoot.right, subRoot.val, max) && isValidBSTSub(subRoot.left, min, subRoot.val);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4,
                new TreeNode(3), new TreeNode(6)))));

        System.out.println(new Solution().isValidBST(new TreeNode(5)));

        System.out.println(new Solution().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

        System.out.println(new Solution().isValidBST(new TreeNode(5, new TreeNode(14, new TreeNode(1), null), null)));
    }
}