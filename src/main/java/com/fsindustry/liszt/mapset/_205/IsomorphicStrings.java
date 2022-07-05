package com.fsindustry.liszt.mapset._205;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution1 solution = new Solution1();
        String s = "badc", t = "baba";
        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isIsomorphic(s, t));
    }

}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 可使用int数组替代
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 检查s到t的映射
            Character sc = sMap.get(s.charAt(i));
            if (null == sc) {
                sMap.put(s.charAt(i), t.charAt(i));
            } else {
                if (sc != t.charAt(i)) {
                    return false;
                }
            }

            // 检查t到s的映射
            Character tc = tMap.get(t.charAt(i));
            if (null == tc) {
                tMap.put(t.charAt(i), s.charAt(i));
            } else {
                if (tc != s.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}


class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 可使用int数组替代
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            // 检查s到t的映射
            if (sMap[s.charAt(i)] == 0) {
                sMap[s.charAt(i)] = t.charAt(i);
            } else {
                if (sMap[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }

            // 检查t到s的映射
            if (tMap[t.charAt(i)] == 0) {
                tMap[t.charAt(i)] = s.charAt(i);
            } else {
                if (tMap[t.charAt(i)] != s.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}