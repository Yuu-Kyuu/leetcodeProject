package com.leetcode.p239;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> heep = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            heep.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = heep.peek()[0];
        for (int i = k; i < n; ++i) {
            heep.offer(new int[]{nums[i], i});
            while (heep.peek()[1] <= i - k) {
                heep.poll();
            }
            ans[i - k + 1] = heep.peek()[0];
        }
        return ans;
    }
}


//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        if (length <= k) {
//            return new int[]{Arrays.stream(nums).max().getAsInt()};
//        }
//
//        int[] result = new int[length - k + 1];
//
//        int currentMaxIndex = 0;
//        //求初始窗口的最大值
//        for (int i = 0; i < k; i++) {
//            if (nums[i] > nums[currentMaxIndex]) {
//                currentMaxIndex = i;
//            }
//        }
//        result[0] = nums[currentMaxIndex];
//        for (int i = 1; i < result.length; i++) {
//            System.out.println(currentMaxIndex);
//            //划出去的是最大值
//            if (i - 1 == currentMaxIndex) {
//                currentMaxIndex = i;
//                for (int j = i; j < i + k; j++) {
//                    if (nums[j] > nums[currentMaxIndex]) {
//                        currentMaxIndex = j;
//                    }
//                }
//                result[i] = nums[currentMaxIndex];
//            } else {
//                if (nums[currentMaxIndex] <= nums[i + k - 1]) {
//                    currentMaxIndex = i + k - 1;
//                }
//                result[i] = nums[currentMaxIndex];
//
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, -1}, 1)));
//    }
//}