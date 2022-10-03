package com.fsindustry.liszt.backtracking._216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumIII {
}

class Solution {
    private List<List<Integer>> res;

    private void findCombine(int count, int sum, int start, List<Integer> path) {
        if (count == path.size()) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (sum - i >= 0) {
                path.add(i);
                findCombine(count, sum - i, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n < k){
            return Collections.emptyList();
        }

        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findCombine(k, n, 1, path);
        return res;
    }
}