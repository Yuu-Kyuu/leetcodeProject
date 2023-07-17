package com.leetcode.daily.p415;

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addSmallString2Big(num1, num2, num2.length() - num1.length());
        } else {
            return addSmallString2Big(num2, num1, num1.length() - num2.length());
        }
    }

    private String addSmallString2Big(String small, String big, int lengthDiff) {
        StringBuilder result = new StringBuilder();
        int currentAdd = 0;

        for (int i = big.length() - 1; i >= lengthDiff; i--) {
            int current = currentAdd + (big.charAt(i) - '0') + (small.charAt(i - lengthDiff) - '0');
            result.insert(0, current % 10);
            if (current > 9) {
                currentAdd = current / 10;
            } else {
                currentAdd = 0;
            }
        }

        if (currentAdd == 0) {
            result.insert(0, big.substring(0, lengthDiff));
        } else {
            if (lengthDiff == 0) {
                result.insert(0, currentAdd);
            } else {
                StringBuilder perfix = new StringBuilder(big.substring(0, lengthDiff));
                for (int i = perfix.length() - 1; i >= 0; i--) {
                    int current = perfix.charAt(i) - '0' + currentAdd;
                    if (current > 9) {
                        currentAdd = current / 10;
                        perfix.replace(i, i + 1, String.valueOf(current % 10));
                    } else {
                        currentAdd = 0;
                        perfix.replace(i, i + 1, String.valueOf(current % 10));
                        break;
                    }
                }

                if (currentAdd != 0) {
                    perfix.insert(0, currentAdd);
                }

                result.insert(0, perfix);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // System.out.println(
        //         new Solution().addStrings(
        //                 "965851889636410748708524976419405193491",
        //                 // "10748708524976419405193491",
        //                 "76217403373357744506668"));
                         System.out.println(
                new Solution().addStrings(
                        "456",
                        "77"));
    }
}