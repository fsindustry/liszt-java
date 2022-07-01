package com.fsindustry.liszt.array._438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution2 solution = new Solution2();
        String s = "cbaebabacd", p = "abc";
        System.out.println("Input: s = " + s + ", p = " + p);
        System.out.println("Output: " + solution.findAnagrams(s, p));
    }

    public static void test2() {
        Solution2 solution = new Solution2();
        String s = "abab", p = "ab";
        System.out.println("Input: s = " + s + ", p = " + p);
        System.out.println("Output: " + solution.findAnagrams(s, p));
    }
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        // 计算p字符串中各个字符出现的次数
        int[] bitMap = new int[26];
        int matched = 0;
        for (int i = 0; i < p.length(); i++) {
            bitMap[p.charAt(i) - 'a']++;
        }
        int l = 0;
        while (l <= s.length() - p.length()) {
            // 找到起始的l
            if (bitMap[s.charAt(l) - 'a'] == 0) {
                l++;
                continue;
            }
            // 计算当前区间的位图
            int[] destMap = new int[26];
            for (int i = l; i < l + p.length(); i++) {
                destMap[s.charAt(i) - 'a']++;
            }
            // 若匹配，则添加
            if (isMatched(bitMap, destMap)) {
                res.add(l);
            }
            l++;
        }

        return res;
    }

    public boolean isMatched(int[] src, int[] dest) {
        if (src.length != dest.length) {
            return false;
        }

        for (int i = 0; i < src.length; i++) {
            if (src[i] != dest[i]) {
                return false;
            }
        }
        return true;
    }
}


class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {

        // 若p比s长，则无比较必要，直接返回空集
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        // 生成p对应的字符map，用于后续比较
        int[] expMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            expMap[p.charAt(i) - 'a']++;
        }

        // 存放滑动窗口的字符map
        List<Integer> res = new ArrayList<>();
        int l = 0, r = -1; // [l, r]区间表示已经匹配到字符串的项
        int[] actMap = new int[26];
        while (r < s.length() - 1) {
            // 增加窗口长度，直至长度达到p长度时，进行比较
            r++;
            actMap[s.charAt(r) - 'a']++;

            // 若窗口大于p长度，则缩减窗口范围
            if (r - l + 1 > p.length()) {
                actMap[s.charAt(l) - 'a']--;
                l++;
            }

            // 若窗口长度等于p长度，则进行一次比较
            if (r - l + 1 == p.length() && isMatched(expMap, actMap)) {
                res.add(l);
            }
        }

        return res;
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