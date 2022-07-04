package com.fsindustry.liszt.mapset._205;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution solution = new Solution();
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
            Character sc = sMap.get(s.charAt(i));
            if (null == sc) {
                sMap.put(s.charAt(i), t.charAt(i));
            } else {
                if (sc != t.charAt(i)) {
                    return false;
                }
            }

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