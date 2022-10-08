package com.fsindustry.liszt.backtracking._200;

public class NumberOfIslands {
}

class Solution {

    private int m, n;
    private boolean[][] visited;
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void findIsland(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + move[i][0];
            int newy = y + move[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                findIsland(grid, newx, newy);
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int res = 0;
        visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    res++;
                    findIsland(grid, x, y);
                }
            }
        }
        return res;
    }
}