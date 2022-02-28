package com.leetcode.list.p25;

import com.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode nextKStart = null;
        ListNode lastKEnd = null;
        Stack<ListNode> stack = new Stack<>();
        int currentNodeNum = 0;
        while (head != null) {
            stack.push(head);
            currentNodeNum++;
            if (stack.size() == k) {
                nextKStart = head.next;
                if (currentNodeNum == k) {
                    result = stack.peek();
                }

                for (int i = 0; i < k; i++) {
                    if (lastKEnd != null && i == 0) {
                        lastKEnd.next = stack.peek();
                    }
                    lastKEnd = stack.pop();
                    lastKEnd.next = stack.isEmpty() ? nextKStart : stack.peek();
                }
                head = nextKStart;
            } else {
                head = head.next;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2));
    }
}