package com.acwing.p145;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> data = new ArrayList<>(10000);
    static int[] fa = new int[10001];
    static int length;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            length = s.nextInt();
            for (int i = 0; i < length; i++) {
                data.add(new int[]{s.nextInt(), s.nextInt()});
            }
            data.sort(Comparator.comparingInt(o -> o[0]));

            for (int i = 0; i < fa.length; i++) {
                fa[i] = i;
            }

            int ans = 0;
            for (int i = length - 1; i >= 0; i--) {
                int profit = data.get(i)[0];
                int day = data.get(i)[1];
                int lastAvailableDay = find(day);
                if (lastAvailableDay > 0) {
                    ans += profit;
                    fa[lastAvailableDay] = lastAvailableDay - 1;
                }
            }
            System.out.println(ans);
            data.clear();
        }
        s.close();
        System.exit(0);
    }

    private static int find(int day) {
        if (day == fa[day]) {
            return day;
        }
        return fa[day] = find(fa[day]);
    }
}