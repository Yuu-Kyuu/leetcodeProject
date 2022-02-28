package com.leetcode.p88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int[] tmp1 = new int[m];
        System.arraycopy(nums1, 0, tmp1, 0, m);

        int index = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        while (nums1Index < m && nums2Index < n) {
            if (tmp1[nums1Index] <= nums2[nums2Index]) {
                nums1[index] = tmp1[nums1Index];
                nums1Index++;
            } else {
                nums1[index] = nums2[nums2Index];
                nums2Index++;
            }
            index++;
        }

        if (nums1Index < m) {
            System.arraycopy(tmp1, nums1Index, nums1, index, m - nums1Index);
        }

        if (nums2Index < n) {
            System.arraycopy(nums2, nums2Index, nums1, index, n - nums2Index);
        }
    }
}