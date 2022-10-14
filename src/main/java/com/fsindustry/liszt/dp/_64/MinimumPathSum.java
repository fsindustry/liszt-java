package com.fsindustry.liszt.dp._64;

import java.util.Arrays;

public class MinimumPathSum {
}

class Solution {
    int m, n;
    int[][] cache;

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }


    public int minPathSum(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }


        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0) {
                    cache[x][y] = grid[x][y];
                } else {
                    if (inArea(x - 1, y) && inArea(x, y - 1)) {
                        cache[x][y] = grid[x][y] + Math.min(cache[x - 1][y], cache[x][y - 1]);
                    } else if (inArea(x - 1, y)) {
                        cache[x][y] = grid[x][y] + cache[x - 1][y];
                    } else {
                        assert inArea(x, y - 1);
                        cache[x][y] = grid[x][y] + cache[x][y - 1];
                    }
                }
            }
        }

        return cache[m - 1][n - 1];
    }
}

class Solution1 {

    int m, n;
    int[][] cache;

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int findMin(int[][] grid, int x, int y) {

        if (x == 0 && y == 0) {
            return grid[0][0];
        }

        if (inArea(x - 1, y) && cache[x - 1][y] == Integer.MAX_VALUE) {
            cache[x - 1][y] = findMin(grid, x - 1, y);
        }

        if (inArea(x, y - 1) && cache[x][y - 1] == Integer.MAX_VALUE) {
            cache[x][y - 1] = findMin(grid, x, y - 1);
        }

        if (inArea(x - 1, y) && inArea(x, y - 1)) {
            cache[x][y] = grid[x][y] + Math.min(cache[x - 1][y], cache[x][y - 1]);
        } else if (inArea(x - 1, y)) {
            cache[x][y] = grid[x][y] + cache[x - 1][y];
        } else {
            assert inArea(x, y - 1);
            cache[x][y] = grid[x][y] + cache[x][y - 1];
        }

        return cache[x][y];
    }

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }

        return findMin(grid, m - 1, n - 1);
    }
}