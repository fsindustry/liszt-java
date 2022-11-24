package com.fsindustry.liszt.algr.dp._62;

import java.util.Arrays;

public class UniquePaths {
}

// dynamic program
class Solution {

    private int maxX, maxY;
    private int[][] cache;

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    public int uniquePaths(int m, int n) {
        maxX = m - 1;
        maxY = n - 1;
        cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0) {
                    cache[x][y] = 1;
                } else {
                    int count = 0;
                    if (inArea(x - 1, y)) {
                        count += cache[x - 1][y];
                    }

                    if (inArea(x, y - 1)) {
                        count += cache[x][y - 1];
                    }
                    cache[x][y] = count;
                }
            }
        }

        return cache[m - 1][n - 1];
    }
}


// memory search
class Solution1 {

    private int maxX, maxY;
    private int[][] cache;

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    private int countPath(int x, int y) {
        if (!inArea(x, y)) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        if (cache[x][y] != -1) {
            return cache[x][y];
        }

        return cache[x][y] = countPath(x - 1, y) + countPath(x, y - 1);
    }

    public int uniquePaths(int m, int n) {
        maxX = m - 1;
        maxY = n - 1;
        cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return countPath(maxX, maxY);
    }
}

// recursion: timeout
class Solution2 {

    private int maxX, maxY;

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    private int countPath(int x, int y) {
        if (!inArea(x, y)) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        return countPath(x - 1, y) + countPath(x, y - 1);
    }

    public int uniquePaths(int m, int n) {
        maxX = m - 1;
        maxY = n - 1;
        return countPath(maxX, maxY);
    }
}