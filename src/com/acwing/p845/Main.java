package com.acwing.p845;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder start = new StringBuilder("");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            start.append(s.next());
        }
        s.close();
        System.out.println(bfs(start.toString(), target, start.indexOf("x")));
    }

    static String swap(String status, int changeBefore, int changeAfter) {
        StringBuilder newStatus = new StringBuilder(status);
        newStatus.setCharAt(changeBefore, status.charAt(changeAfter));
        newStatus.setCharAt(changeAfter, 'x');
        return newStatus.toString();
    }

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static String target = "12345678x";

    static int evaluate(String status) {
        int ans = 0;
        int[] statusIndex = new int[9];
        for (int i = 0; i < status.length(); i++) {
            if (status.charAt(i) == 'x') {
                statusIndex[i] = 0;
            } else {
                statusIndex[i] = status.charAt(i) - '0';
            }
        }
        int[] target = new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7};
        for (int diget = 1; diget < 9; diget++) {
            int nowx = statusIndex[diget] / 3;
            int nowy = statusIndex[diget] / 3;
            int targetx = target[diget] / 3;
            int targety = target[diget] % 3;
            ans += Math.abs(nowx - targetx) + Math.abs(nowy - targety);

        }
        return ans;
    }

    static int bfs(String start, String end, int xIndex) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, String> mapPath = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.evaluate));
//        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, xIndex, evaluate(start)));
        map.put(start, 0);

        while (!q.isEmpty()) {
            Node current = q.poll();
            String currentStatus = current.status;
            if (currentStatus.equals(end)) {
                //printPath(mapPath, map, end);
                return map.get(currentStatus);

            }

            int currXIndex = current.xIndex;
            int xRow = currXIndex / 3, xColumn = currXIndex % 3;
            for (int i = 0; i < 4; i++) {
                int xRowChange = xRow + dx[i], xColumnChange = xColumn + dy[i];
                if (xRowChange < 3 && xRowChange >= 0 && xColumnChange < 3 && xColumnChange >= 0) {
                    int changedXIndex = xRowChange * 3 + xColumnChange;
                    String changedStatus = swap(currentStatus, currXIndex, changedXIndex);
                    if (map.get(changedStatus) == null) {
                        int step = map.get(currentStatus) + 1;
                        map.put(changedStatus, step);
                        q.offer(new Node(changedStatus, changedXIndex, step + evaluate(changedStatus)));
                        mapPath.put(changedStatus, currentStatus);
                    }
                }
            }

        }
        return -1;
    }

    private static void printPath(Map<String, String> path, Map<String, Integer> data, String start) {
        while (path.get(start) != null) {
            System.out.println(start + ":" + data.get(start) + "   eval:" + evaluate(start));
            start = path.get(start);
        }

    }

    static class Node {
        String status;
        int xIndex;
        int evaluate;

        public Node(String status, int xIndex, int evaluate) {
            this.status = status;
            this.xIndex = xIndex;
            this.evaluate = evaluate;
        }
    }

}