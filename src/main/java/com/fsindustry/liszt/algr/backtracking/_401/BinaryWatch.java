package com.fsindustry.liszt.algr.backtracking._401;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
}

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h << 6 | m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
}