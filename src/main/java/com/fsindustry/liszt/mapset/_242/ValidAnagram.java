package com.fsindustry.liszt.mapset._242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "anagram", t = "nagaram";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

    public static void test2() {
        Solution solution = new Solution();
        String s = "rat", t = "car";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

    public static void test3() {
        Solution solution = new Solution();
        String s = "aacc", t = "ccac";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isAnagram(s, t));
    }

}

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // 如果取值范围较小，可以使用数组代替；
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = countMap.get(s.charAt(i));
            if (count != null) {
                countMap.put(s.charAt(i), ++count);
            } else {
                countMap.put(s.charAt(i), 1);
            }
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
