package com.fsindustry.liszt.backtracking._17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
}

class Solution {

    private String[] digitMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits)) {
            return Collections.emptyList();
        }
        StringBuilder s = new StringBuilder();
        dfs(digits, 0, s);
        return result;
    }

    void dfs(String digits, int idx, StringBuilder path) {
        if (digits.length() == idx) {
            result.add(path.toString());
            return;
        }

        String sub = digitMap[digits.charAt(idx) - '0'];
        for (int i = 0; i < sub.length(); i++) {
            path.append(sub.charAt(i));
            dfs(digits, idx + 1, path);
            path.delete(path.length() -1 , path.length());
        }
    }
}