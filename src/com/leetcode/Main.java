package com.leetcode;


import com.leetcode.p11.Solution;
import javafx.collections.ObservableIntegerArray;

public class Main {

    public static void main(String[] args) {
        binarySearch(new int[]{2,11,15,19,30,32,61,72,88,90,96},15);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        int i = 0;
        while (left <= right) {
            System.out.println(i++);
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
