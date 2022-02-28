package com.leetcode.list.p206;

import com.leetcode.list.ListNode;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if (head == null) {
            return head;
        }
        stack.push(head);
        while (head.next != null) {
            stack.push(head = head.next);
        }

        ListNode result = stack.peek();
        while (!stack.empty()) {
            stack.pop().next = stack.isEmpty() ? null : stack.peek();
        }
        return result;
    }

//    ListNode changeOrder(ListNode current) {
//        if (current.next == null) {
//            return current;
//        }
//
//        current.next.next = current;
//
//
//    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}