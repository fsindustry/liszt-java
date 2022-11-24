package com.fsindustry.liszt.algr.lut._290;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println("Input: pattern = " + pattern + ", s = " + s);
        System.out.println("Output: " + solution.wordPattern(pattern, s));
    }

    public static void test2() {
        Solution solution = new Solution();
        String pattern = "abba", s = "dog dog dog dog";
        System.out.println("Input: pattern = " + pattern + ", s = " + s);
        System.out.println("Output: " + solution.wordPattern(pattern, s));
    }

}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            // 判断 word -> p的映射是否正确
            Character p = wordMap.get(words[i]);
            if (null == p) {
                wordMap.put(words[i], pattern.charAt(i));
            } else {
                if (p != pattern.charAt(i)) {
                    return false;
                }
            }

            // 判断p -> word的映射是否正确
            String word = pMap.get(pattern.charAt(i));
            if (null == word) {
                pMap.put(pattern.charAt(i), words[i]);
            } else {
                if (!word.equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}