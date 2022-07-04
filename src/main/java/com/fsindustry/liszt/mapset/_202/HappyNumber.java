package com.fsindustry.liszt.mapset._202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        int n = 19;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + solution.isHappy(n));
    }

    public static void test2() {
        Solution solution = new Solution();
        int n = 2;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + solution.isHappy(n));
    }
}

class Solution {
    public boolean isHappy(int n) {
        String num = String.valueOf(n);
        Set<Integer> calculated = new HashSet<>();
        while (true) {
            int result = 0;
            for (int i = 0; i < num.length(); i++) {
                int ch = num.charAt(i) - '0';
                result += ch * ch;
            }

            if (result == 1) {
                return true;
            } else if (calculated.contains(result)) {
                return false;
            }
            calculated.add(result);
            num = String.valueOf(result);
        }
    }
}