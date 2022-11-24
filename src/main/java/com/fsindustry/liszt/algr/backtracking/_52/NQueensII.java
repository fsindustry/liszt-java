package com.fsindustry.liszt.algr.backtracking._52;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
}

class Solution {
    private int res;
    private boolean[] col, dia1, dia2;

    private void findPos(int n, int y, List<Integer> row) {
        if (n == y) {
            res++;
            return;
        }

        for (int x = 0; x < n; x++) {
            if (!col[x] && !dia1[x + y] && !dia2[y - x + n - 1]) {
                row.add(x);
                col[x] = dia1[x + y] = dia2[y - x + n - 1] = true;

                findPos(n, y + 1, row);

                row.remove(row.size() - 1);
                col[x] = dia1[x + y] = dia2[y - x + n - 1] = false;
            }
        }
    }

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        List<Integer> row = new ArrayList<>(n);
        findPos(n, 0, row);
        return res;
    }
}
