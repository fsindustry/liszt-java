package com.fsindustry.liszt.lut3._49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Output: " + solution.groupAnagrams(strs));
    }

    public static void test2() {
        Solution solution = new Solution();
        String[] strs = {""};
        System.out.println("Output: " + solution.groupAnagrams(strs));
    }

    public static void test3() {
        Solution solution = new Solution();
        String[] strs = {"a"};
        System.out.println("Output: " + solution.groupAnagrams(strs));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // ( countMap, List(anagram) )
        Map<Map<Character, Integer>, List<String>> aggMap = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> key = genKey(str);
            List<String> anagrams = aggMap.computeIfAbsent(key, v -> new ArrayList<>());
            anagrams.add(str);
        }

        return new ArrayList<>(aggMap.values());
    }

    public Map<Character, Integer> genKey(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        return countMap;
    }
}