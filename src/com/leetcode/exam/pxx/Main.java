package com.leetcode.exam.pxx;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        HashMap<String, Integer> mouseAppear = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String coordinate = s.nextInt() + "," + s.nextInt();
            mouseAppear.put(coordinate, mouseAppear.getOrDefault(coordinate, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            String coordinatePlant = s.nextInt() + "," + s.nextInt();
            mouseAppear.remove(coordinatePlant);
        }
        s.close();

        String maxCoordinate = "0,0";
        int maxAppear = 0;
        for (String coordinate : mouseAppear.keySet()) {
            if (maxAppear < mouseAppear.get(coordinate)) {
                maxAppear = mouseAppear.get(coordinate);
                maxCoordinate = coordinate;
            }
            if (maxAppear == mouseAppear.get(coordinate)) {
                String[] maxCoordinateXY = maxCoordinate.split(",");
                int maxCoordinateX = Integer.parseInt(maxCoordinateXY[0]);
                int maxCoordinateY = Integer.parseInt(maxCoordinateXY[1]);


                String[] coordinateXY = coordinate.split(",");
                int coordinateX = Integer.parseInt(coordinateXY[0]);
                int coordinateY = Integer.parseInt(coordinateXY[1]);

                if (maxCoordinateX + maxCoordinateY > coordinateX + coordinateY) {
                    maxCoordinate = coordinate;
                }
                if (maxCoordinateX + maxCoordinateY == coordinateX + coordinateY && coordinateX < maxCoordinateX) {
                    maxCoordinate = coordinate;
                }
            }
        }
        System.out.println(maxCoordinate.replace(",", " "));
    }
}