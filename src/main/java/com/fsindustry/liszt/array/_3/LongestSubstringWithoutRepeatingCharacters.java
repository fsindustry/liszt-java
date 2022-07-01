package com.fsindustry.liszt.array._3;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s));
    }

    public static void test2() {
        Solution solution = new Solution();
        String s = "bbbbb";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s));
    }

    public static void test3() {
        Solution solution = new Solution();
        String s = "pwwkew";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s));
    }

    public static void test4() {
        Solution solution = new Solution();
        String s = "";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s));
    }

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1; // [l, r]区间表示当前子串，l==r时，子串长度为1，故需要r=-1;
        int res = 0; // 记录最长不重复子串长度，0是最小的子串长度
        int[] checkMap = new int[256]; // 用于匹配字符是否已经出现的bitmap

        while (l < s.length()) {
            // 若下一个元素不重复，则右移r，扩大窗口区间
            if (r < s.length() - 1 && checkMap[s.charAt(r + 1)] == 0) {
                checkMap[s.charAt(++r)]++;
            }
            // 若下一个元素重复，则右移l，缩小窗口区间
            else {
                res = Math.max(res, r - l + 1);
                checkMap[s.charAt(l)]--;
                l++;
            }
        }

        return res;
    }
}
