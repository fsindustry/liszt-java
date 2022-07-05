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
        int startIdx = -1;
        int actualMatched = 0;

        for (int i = 0; i < t.length(); i++) {
            expMap[t.charAt(i)]++;
        }

        int l = 0, r = -1;

        while (l < s.length()) {

            // 向右移动r，扩大滑窗，直至窗口宽度大等t.length，此时才可能比较
            if (r < s.length() - 1 && actualMatched < t.length()) {
                r++;
                actMap[s.charAt(r)]++;
                // 隐藏条件：expMap[s.charAt(r)] > 0，即字符在t中存在
                if (actMap[s.charAt(r)] <= expMap[s.charAt(r)]) {
                    actualMatched++;
                }
            } else {
                assert actualMatched <= t.length();

                // 如果找到匹配的子串，且子串长度<当前最小长度，则取当前子串
                if (actualMatched == t.length() && r - l + 1 < subLen) {
                    subLen = r - l + 1;
                    startIdx = l;
                }

                actMap[s.charAt(l)]--;
                if (actMap[s.charAt(l)] < expMap[s.charAt(l)]) {
                    actualMatched--;
                }
                l++;
            }
        }

        // 若找到子串，则截取并返回子串
        if (startIdx != -1) {
            return s.substring(startIdx, startIdx + subLen);
        }

        // 若未找到子串，则返回空字符串
        return "";
    }
}