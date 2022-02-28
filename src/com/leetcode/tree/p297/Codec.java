package com.leetcode.tree.p297;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serializedList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                serializedList.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                serializedList.add("null");
            }

        }
        return "[" + String.join(",", serializedList) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "" || data.equals("[null]") || data.equals("[]")) {
            return null;
        }
        String[] deserializedList = data.substring(1, data.length() - 1).split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(deserializedList[0]));
        queue.push(root);
        for (int i = 1; i < deserializedList.length; i++) {
            TreeNode subRoot = queue.poll();
            if (!deserializedList[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(deserializedList[i]));
                subRoot.left = left;
                queue.add(left);
            }
            i++;
            if (!deserializedList[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(deserializedList[i]));
                subRoot.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}