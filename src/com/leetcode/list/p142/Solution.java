package com.leetcode.list.p142;

import com.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> elements = new HashSet<>();
        while (head.next != null) {
            if (!elements.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().detectCycle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}