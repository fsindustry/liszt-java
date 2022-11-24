package com.fsindustry.liszt.algr.backtracking._417;

import java.util.*;

public class PacificAtlanticWaterFlow {
}

class Solution {

    private int m, n;
    private boolean[][] visited;
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void bfs(int[][] heights, int x, int y, boolean[][] visited) {

        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newx = cur.x + move[i][0];
                int newy = cur.y + move[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] && heights[cur.x][cur.y] <= heights[newx][newy]) {
                    visited[newx][newy] = true;
                    q.add(new Point(newx, newy));
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        if (0 == m) {
            return Collections.emptyList();
        }
        n = heights[0].length;
        if (0 == n) {
            return Collections.emptyList();
        }

        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            bfs(heights, x, 0, visitedP);
            bfs(heights, x, n - 1, visitedA);
        }
        for (int y = 0; y < n; y++) {
            bfs(heights, 0, y, visitedP);
            bfs(heights, m - 1, y, visitedA);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (visitedP[x][y] && visitedA[x][y]) {
                    List<Integer> p = new ArrayList<>(2);
                    p.add(x);
                    p.add(y);
                    res.add(p);
                }
            }
        }
        return res;
    }
}

class Solution1 {

    private int m, n;
    private boolean[][] visited;
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void dfs(int[][] heights, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + move[i][0];
            int newy = y + move[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && heights[x][y] <= heights[newx][newy]) {
                dfs(heights, newx, newy, visited);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        if (0 == m) {
            return Collections.emptyList();
        }
        n = heights[0].length;
        if (0 == n) {
            return Collections.emptyList();
        }

        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            dfs(heights, x, 0, visitedP);
            dfs(heights, x, n - 1, visitedA);
        }
        for (int y = 0; y < n; y++) {
            dfs(heights, 0, y, visitedP);
            dfs(heights, m - 1, y, visitedA);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (visitedP[x][y] && visitedA[x][y]) {
                    List<Integer> p = new ArrayList<>(2);
                    p.add(x);
                    p.add(y);
                    res.add(p);
                }
            }
        }
        return res;
    }
}