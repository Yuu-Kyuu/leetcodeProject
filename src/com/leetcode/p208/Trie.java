package com.leetcode.p208;

import java.util.HashMap;

class Trie {
    class Node {
        int count;
        HashMap<Character, Node> child;

        public Node() {
            this.count = 0;
            this.child = new HashMap<>();
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        find(word, true, false);
    }

    public boolean search(String word) {
        return find(word, false, false);
    }

    public boolean startsWith(String prefix) {
        return find(prefix, false, true);
    }

    private boolean find(String s, boolean isInsert, boolean isPerfix) {
        Node curr = root;
        for (char ch : s.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                if (isInsert) {
                    curr.child.put(ch, new Node());
                } else {
                    return false;
                }
            }
            curr = curr.child.get(ch);
        }

        if (isInsert) {
            curr.count++;
        }
        if (isPerfix) {
            return true;
        }
        return curr.count > 0;
    }
}
