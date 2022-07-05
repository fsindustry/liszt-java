package com.fsindustry.liszt.lut._242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution1 solution = new Solution1();
        String s = "anagram", t = "nagaram";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

    public static void test2() {
        Solution1 solution = new Solution1();
        String s = "rat", t = "car";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

    public static void test3() {
        Solution1 solution = new Solution1();
        String s = "aacc", t = "ccac";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

}

class Solution {
    public boolean isAnagram(String s, String t) {
        // 长度不同，则直接否决
        if (s.length() != t.length()) {
            return false;
        }

        // 如果取值范围较小，可以使用数组代替；
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer count = countMap.get(t.charAt(i));
            if (null == count || 0 == count) {
                return false;
            } else {
                countMap.put(t.charAt(i), --count);
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean isAnagram(String s, String t) {
        // 长度不同，则直接否决
        if (s.length() != t.length()) {
            return false;
        }

        // 如果取值范围较小，使用数组代替map，统计元数出现次数；
        int[] countMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countMap[s.charAt(i) - 'a']++;
        }

        // 由于每个字母只出现一次，故直接判断字母在t中是否存在即可
        for (int i = 0; i < t.length(); i++) {
            if (0 == countMap[t.charAt(i) - 'a']) {
                return false;
            } else {
                countMap[t.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
