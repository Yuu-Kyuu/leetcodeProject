package com.leetcode.stack.p155;

import java.util.Stack;

class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minData;

    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (minData.isEmpty()) {
            minData.push(val);
        } else {
            minData.push(Math.min(minData.peek(), val));
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}
