package com.leetcode.p8;

class Solution {
    public int myAtoi(String s) {
        StringBuilder numStr = new StringBuilder();
        Character f = 'z';
        for (Character c : s.toCharArray()) {
            if (numStr.length() > 10) {
                break;
            }
            if (c == ' ' || c == '-' || c == '+' || Character.isDigit(c)) {
                if (c == ' ') {
                    if (numStr.length() == 0 && f == 'z') {
                        continue;
                    } else {
                        break;
                    }
                }
                if (c == '+' || c == '-') {
                    if (numStr.length() != 0) {
                        break;
                    } else {
                        if (f != 'z') {
                            return 0;
                        } else {
                            f = c;
                            continue;
                        }
                    }
                }

                //"00000-42a1234"
                if (c == '0' && numStr.length() == 1 && numStr.charAt(0) == '0') {
                    continue;
                }

                numStr.append(c);
            } else {
                if (numStr.length() == 0) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        if (numStr.length() == 0) {
            return 0;
        }
        if (f == '-') {
            numStr.insert(0, f);
        }
        Long result = Long.parseLong(numStr.toString());
        result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        return result.intValue();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().myAtoi(" +0 123"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().myAtoi("20000000000000000000"));

    }
}