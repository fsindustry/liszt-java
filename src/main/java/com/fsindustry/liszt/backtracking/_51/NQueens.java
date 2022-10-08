package com.fsindustry.liszt.backtracking._51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {


}

class Solution {

    private List<List<String>> res;
    private boolean[] col, dia1, dia2;

    private void findPos(int n, int rowIdx, List<Integer> rows) {
        if (n == rowIdx) {
            res.add(printRes(n, rows));
            return;
        }

        for (int colIdx = 0; colIdx < n; colIdx++) {
            if (!col[colIdx] && !dia1[rowIdx + colIdx] && !dia2[rowIdx - colIdx + n - 1]) {
                rows.add(colIdx);
                col[colIdx] = true;
                dia1[rowIdx + colIdx] = true;
                dia2[rowIdx - colIdx + n - 1] = true;

                findPos(n, rowIdx + 1, rows);

                rows.remove(rows.size() - 1);
                col[colIdx] = false;
                dia1[rowIdx + colIdx] = false;
                dia2[rowIdx - colIdx + n - 1] = false;
            }
        }
    }

    private List<String> printRes(int n, List<Integer> rows) {
        List<String> ele = new ArrayList<>(n);
        for (int colIdx : rows) {
            char[] tmp = new char[n];
            Arrays.fill(tmp, '.');
            tmp[colIdx] = 'Q';
            ele.add(String.valueOf(tmp));
        }
        return ele;
    }

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        res = new ArrayList<>();
        List<Integer> rows = new ArrayList<>(n);
        findPos(n, 0, rows);

        return res;
    }
}