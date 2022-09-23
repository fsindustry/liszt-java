package com.fsindustry.liszt.backtracking._131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        System.out.println(s.partition("aab"));
    }
}

class Solution {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (null == s || "".equals(s)) {
            return Collections.emptyList();
        }
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int start, List<String> path) {
        if (s.length() <= start) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                dfs(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}