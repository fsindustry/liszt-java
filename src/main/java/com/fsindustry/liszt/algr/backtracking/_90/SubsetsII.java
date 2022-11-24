package com.fsindustry.liszt.algr.backtracking._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {
}

class Solution {

    private List<List<Integer>> res;

    private void findCombine(int[] nums, int k, int start, List<Integer> path) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        int end = nums.length - (k - path.size()) + 1;
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            findCombine(nums, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        res = new ArrayList<>();
        res.add(Collections.emptyList());
        List<Integer> path = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            findCombine(nums, i, 0, path);
        }
        return res;
    }
}