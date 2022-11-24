package com.fsindustry.liszt.algr.backtracking._39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(s.combinationSum(candidates, 7));
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
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                findCombine(candidates, target - candidates[i], i, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        assert null != candidates && candidates.length > 0;

        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findCombine(candidates, target, 0, path);
        return res;
    }
}