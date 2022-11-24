package com.fsindustry.liszt.algr.backtracking._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(s.combinationSum2(candidates, 8));
    }
}

class Solution {

    private List<List<Integer>> res;

    private void findCombine(int[] candidates, int target, int start, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // caution: i must be larger than start not 0
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                findCombine(candidates, target - candidates[i], i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (null == candidates || 0 == candidates.length) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findCombine(candidates, target, 0, path);
        return res;
    }
}