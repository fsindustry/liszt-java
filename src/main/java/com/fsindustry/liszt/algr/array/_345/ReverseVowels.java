package com.fsindustry.liszt.algr.array._345;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "hello";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.reverseVowels(s));
    }

    public static void test2() {
        Solution solution = new Solution();
        String s = "leetcode";
        System.out.println("Input: " + s);
        System.out.println("Output: " + solution.reverseVowels(s));
    }
}


class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (!isVowel(arr[l])) {
                l++;
                continue;
            }

            if (!isVowel(arr[r])) {
                r--;
                continue;
            }

            swap(arr, l, r);
            // 注意：满足判断条件也需要调整索引，判断下一组数据
            l++;
            r--;
        }

        return String.valueOf(arr);
    }

    public boolean isVowel(int ch) {
        if ('a' <= ch && ch <= 'z') {
            ch = ch - 32;
        }

        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public void swap(char[] arr, int idx1, int idx2) {
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}