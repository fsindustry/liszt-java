package com.fsindustry.liszt.array._125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.isPalindrome(s));
    }

    public static void test2() {
        Solution solution = new Solution();
        String s = "race a car";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.isPalindrome(s));
    }


    public static void test3() {
        Solution solution = new Solution();
        String s = " ";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.isPalindrome(s));
    }


    public static void test4() {
        Solution solution = new Solution();
        String s = "";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.isPalindrome(s));
    }

    public static void test5() {
        Solution solution = new Solution();
        String s = "0P";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.isPalindrome(s));
    }
}

class Solution {
    public boolean isPalindrome(String s) {

        assert null != s;

        int l = 0, r = s.length() - 1; // 定义字符串的左右索引
        // 循环不变量：(l, r)当前待判断回文的区间，l==r时，就已经是回文了，直接返回即可
        while (l < r) {
            int lv = s.charAt(l);
            int rv = s.charAt(r);

            if (!isValidChar(lv)) {
                l++;
                continue;
            }

            if (!isValidChar(rv)) {
                r--;
                continue;
            }

            // 回文只要有一次不想等，即不是回文
            if (!isEquals(lv, rv)) {
                return false;
            }

            l++;
            r--;
        }

        // 所有匹配均相等，才是回文
        return true;
    }

    public boolean isValidChar(int ch) {
        return isDight(ch) || isAlphabet(ch);
    }

    public boolean isDight(int ch) {
        return '0' <= ch && ch <= '9';
    }

    public boolean isAlphabet(int ch) {
        return ('a' <= ch && ch <= 'z') ||
                ('A' <= ch && ch <= 'Z');
    }

    public boolean isEquals(int ch1, int ch2) {
        // 若是数字，则直接比较
        if (isDight(ch1)) {
            return ch1 == ch2;
        }

        // 若是字母，则转为大写后比较
        if ('a' <= ch1 && ch1 <= 'z') {
            ch1 = ch1 - 32;
        }
        if ('a' <= ch2 && ch2 <= 'z') {
            ch2 = ch2 - 32;
        }
        return ch1 == ch2;
    }
}
