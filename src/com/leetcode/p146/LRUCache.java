package com.leetcode.p146;

import java.util.HashMap;

public class LRUCache {
    private int capacity, size;
    private HashMap<Integer, Node> data;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);
        size = 0;
        first = new Node(-1, -1);
        last = new Node(-2, -2);
        first.next = last;
        last.pre = first;
    }

    public int get(int key) {
        Node node = data.get(key);
        if (node == null) {
            return -1;
        }
        moveNode2First(node);
//        printOrder();
        return node.val;
    }

    public void put(int key, int value) {
        Node node = data.get(key);
        if (node == null) {
            if (size == capacity) {
                Node oldLast = data.remove(last.pre.key);
                oldLast.pre.next = last;
                last.pre = oldLast.pre;
                oldLast.pre = null;
                oldLast.next = null;
            } else {
                size++;
            }
            node = new Node(key, value, first, first.next);
            first.next.pre = node;
            first.next = node;
            data.put(key, node);
        } else {
            moveNode2First(node);
            node.val = value;
        }
//        printOrder();
    }

    private void moveNode2First(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = first.next;
        node.pre = first;

        first.next.pre = node;
        first.next = node;
    }

    private void printOrder() {
        Node n = first;
        while (n.next != null) {
            System.out.print("[" + n.key + ":" + n.val + "]->");
            n = n.next;
        }
        System.out.print("|||");

        n = last;
        while (n.pre != null) {
            System.out.print("[" + n.key + ":" + n.val + "]->");
            n = n.pre;
        }
        System.out.print("\n");
    }

    class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}

