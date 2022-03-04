package com.leetcode.p547;

class Solution {
    int[] f;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        int ans = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(i, j)) {
                        ans--;
                    }
                }
            }
        }
        return ans;
    }

    public int find(int i) {
        if (i == f[i]) {
            return i;
        }
        return f[i] = find(f[i]);
    }

    public boolean union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            f[pRoot] = qRoot;
            return true;
        }
        return false;
    }
}

