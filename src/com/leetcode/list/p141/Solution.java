package com.leetcode.list.p141;

import com.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> elements = new HashSet<>();
        while (head.next != null) {
            if (!elements.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}