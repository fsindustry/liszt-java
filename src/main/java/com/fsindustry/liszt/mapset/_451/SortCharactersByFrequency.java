package com.fsindustry.liszt.mapset._451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        test1();
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
        // 通过map统计字符串，将相同字符连接成字符串
        Map<Character, StringBuilder> countMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), new StringBuilder()).append(s.charAt(i)));
        }

        // 通过优先队列，对map中的字符串排序，排序依据字符串长度
        PriorityQueue<StringBuilder> queue = new PriorityQueue<>((a, b) -> (b.length() - a.length()));
        queue.addAll(countMap.values());

        // 依次按长度从大到小，弹出字符串，拼接返回结果
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }
}

class Solution1 {
    public String frequencySort(String s) {
        // 统计字符出现次数，放入map
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 将字符统计放入优先队列
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        queue.addAll(countMap.entrySet());

        // 按照统计次数多少降序拼接字符串
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }

        return builder.toString();
    }
}

