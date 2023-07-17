package com.leetcode.list.p206;

import com.leetcode.list.ListNode;

import java.util.Stack;

class Solution {
//    public ListNode reverseList(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        if (head == null) {
//            return head;
//        }
//        stack.push(head);
//        while (head.next != null) {
//            stack.push(head = head.next);
//        }
//
//        ListNode result = stack.peek();
//        while (!stack.empty()) {
//            stack.pop().next = stack.isEmpty() ? null : stack.peek();
//        }
//        return result;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode tmp = head;
        ListNode before = head;
        ListNode after = head.next;
        while (tmp != null) {
            System.out.println(tmp.val + "" + before.val + "" + after.val);
            tmp = after.next;
            after.next = before;
            //before.next = after;
            before = after;
            after = tmp;
        }

        head.next = null;
        return before;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}