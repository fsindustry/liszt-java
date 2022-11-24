package com.fsindustry.liszt.algr.array._344;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Input: " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("Output: " + Arrays.toString(s));
    }

    public static void test2() {
        Solution solution = new Solution();
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("Input: " + Arrays.toString(s));
        solution.reverseString(s);
        System.out.println("Output: " + Arrays.toString(s));
    }

}

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            swap(s, i, j);
        }
    }

    public void swap(char[] arr, int idx1, int idx2) {
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
