package com.fsindustry.liszt.array._76;


public class MinimumWindowSubstring {

    public static void main(String[] args) {
        test1();
//        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.minWindow(s, t));
    }
}


class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] expMap = new int[256];
        int[] actMap = new int[256];
        int subLen = s.length() + 1;
        int startIdx = 0;
        int actualMatched = 0;

        for (int i = 0; i < t.length(); i++) {
            expMap[t.charAt(i)]++;
        }

        int l = 0, r = -1;

        while (l < s.length() - 1) {

            if (r < s.length() - 1 && actualMatched < t.length()) {
                r++;
                if (expMap[s.charAt(r)] > 0) {
                    actMap[s.charAt(r)]++;
                    actualMatched++;
                }
            }

            if (actualMatched == t.length() && isMatched(expMap, actMap)) {
                subLen = Math.min(subLen, r - l + 1);
                startIdx = l;

                if (expMap[s.charAt(l)] > 0) {
                    actualMatched--;
                }
                l++;
            }

            if (expMap[s.charAt(l)] == 0) {
                if (expMap[s.charAt(l)] > 0) {
                    actualMatched--;
                }
                l++;
            }
        }

        return s.substring(startIdx, startIdx + subLen + 1);
    }

    // 比较p的字符map和滑动窗口的字符map是否相等
    public boolean isMatched(int[] src, int[] dest) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] != dest[i]) {
                return false;
            }
        }
        return true;
    }
}