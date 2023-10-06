package com.fsindustry.liszt.algr.greedy._435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort intervals by end index first, and then by start index
        Arrays.sort(intervals, Comparator.comparing(arr -> arr[1]));

        int pre = 0, cur = 1, res = 1;
        while (cur < intervals.length) {
            if (intervals[cur][0] >= intervals[pre][1]) {
                res++;
                pre = cur;
            }
            cur++;
        }

        return intervals.length - res;
    }
}