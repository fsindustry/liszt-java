package com.fsindustry.liszt.mapset._451;

import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        String s = "tree";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.frequencySort(s));
    }

    public static void test2() {
        Solution solution = new Solution();
        String s = "Aabb";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.frequencySort(s));
    }
}

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = countMap.computeIfAbsent(s.charAt(i), v -> 0);
            countMap.put(s.charAt(i), ++count);
        }

        int i = 0;
        char[] res = new char[s.length()];
        // for-each迭代器的遍历顺序是怎样的？
        // Tree map的排序顺序是怎样的？
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                res[i++] = entry.getKey();
            }
        }
        return String.valueOf(res);
    }
}