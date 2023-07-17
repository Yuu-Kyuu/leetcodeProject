
package com.leetcode.daily.p735;

import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        for (int i = 0; i < asteroids.length - 1; i++) {
            if (asteroids[i] * asteroids[i + 1] < 0) {
                if (Math.abs(asteroids[i]) < Math.abs(asteroids[i + 1])) {
                    asteroids[i] = 0;
                    compairforword(i - 1, i + 1, asteroids);
                } else if (Math.abs(asteroids[i]) > Math.abs(asteroids[i + 1])) {
                    asteroids[i + 1] = asteroids[i];
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    asteroids[i + 1] = 0;
                }
            }
        }

        return Arrays.stream(asteroids).filter(i -> i != 0).toArray();
    }

    public void compairforword(int position, int currentIndex, int[] data) {
        if (position < 0 || data[position] == 0) return;

        if (Math.abs(data[position]) < Math.abs(data[currentIndex])) {
            data[position] = 0;
            compairforword(position - 1, currentIndex, data);
        } else if (Math.abs(data[position]) > Math.abs(data[currentIndex])) {
            data[currentIndex] = data[position];
            data[position] = 0;
        } else {
            data[position] = 0;
            data[currentIndex] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{10, 2, -5})));
    }
}