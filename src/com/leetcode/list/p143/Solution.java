package com.leetcode.list.p143;

import java.util.LinkedList;

import com.leetcode.list.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head);
            head = head.next;
        }

        head = linkedList.remove(0);
        ListNode current = linkedList.remove(linkedList.size() - 1);
        head.next = current;
        while (!linkedList.isEmpty()) {
            ListNode tmp = linkedList.remove(0);
            current.next = tmp;
            current = tmp;
            if (!linkedList.isEmpty()) {
                tmp = linkedList.remove(linkedList.size() - 1);
                current.next = tmp;
                current = tmp;
            }
        }
        current.next = null;
        System.out.println(head);
    }

    public static void main(String[] args) {
        new Solution()
                .reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
    }
}