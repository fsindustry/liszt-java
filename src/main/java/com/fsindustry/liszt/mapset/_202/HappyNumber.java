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
            // 计算当前数字各数位的平方和
            int result = 0;
            for (int i = 0; i < num.length(); i++) {
                int ch = num.charAt(i) - '0';
                result += ch * ch;
            }

            // 若等于1，则为Happy Number
            if (result == 1) {
                return true;
            }
            // 若在calculated中有重复值，则说明进入死循环，不是Happy Number
            else if (calculated.contains(result)) {
                return false;
            }

            // 若既不是1，也未进入死循环，则记录计算结果，继续下一次计算
            calculated.add(result);
            num = String.valueOf(result);
        }
    }
}

class Solution1 {
    public boolean isHappy(int n) {
        int num = n;
        Set<Integer> calculated = new HashSet<>();
        while (true) {
            // 计算当前数字各数位的平方和
            int result = calculate(num);

            // 若等于1，则为Happy Number
            if (result == 1) {
                return true;
            }
            // 若在calculated中有重复值，则说明进入死循环，不是Happy Number
            else if (calculated.contains(result)) {
                return false;
            }

            // 若既不是1，也未进入死循环，则记录计算结果，继续下一次计算
            calculated.add(result);
            num = result;
        }
    }

    public int calculate(int num) {
        int sum = 0;
        while (num > 0) {
            int mod = num % 10;
            sum += mod * mod;
            num = num / 10;
        }
        return sum;
    }
}