package com.leetcode.list.p160;

import java.util.HashSet;

import com.leetcode.list.ListNode;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution().getIntersectionNode(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))),
                new ListNode(3, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
    }
}