package com.acwing.p136;


import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TreeMap<Integer, Integer> data = new TreeMap<>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int current = s.nextInt();
            data.put(current, i);
            if (i > 0) {
                Integer ajl = data.lowerKey(current);
                Integer ajh = data.higherKey(current);
                int aj = 0;
                if (ajl == null) {
                    aj = ajh;
                } else if (ajh == null) {
                    aj = ajl;
                } else {
                    int minl = current - ajl;
                    int minh = ajh - current;
                    if (minl < minh) {
                        aj = ajl;
                    } else if (minl > minh) {
                        aj = ajh;
                    } else {
                        if (ajl < ajh) {
                            aj = ajl;
                        } else {
                            aj = ajh;
                        }
                    }
                }
                System.out.println(Math.abs(current - aj) + " " + (data.get(aj) + 1));
            }
        }
        s.close();
    }
}