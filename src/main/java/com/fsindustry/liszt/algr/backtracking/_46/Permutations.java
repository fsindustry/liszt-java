package com.fsindustry.liszt.algr.backtracking._46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.permute(nums));
    }
}


class Solution {
    private List<List<Integer>> res;
    private boolean[] used;

    private void findPermute(int[] nums, List<Integer> path) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                findPermute(nums, path);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }

        res = new ArrayList<>();
        used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>(nums.length);
        findPermute(nums, path);
        return res;
    }
}