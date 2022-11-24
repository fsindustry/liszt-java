package com.fsindustry.liszt.algr.backtracking._77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));
    }
}

class Solution {
    private List<List<Integer>> res;

    private void findCombine(int n, int k, int start, List<Integer> path) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        int end = n - (k - path.size()) + 1;
        for (int idx = start; idx <= end; idx++) {
            path.add(idx);
            findCombine(n, k, idx + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        assert k >= 0 && n >= k;
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        findCombine(n, k, 1, path);
        return res;
    }
}