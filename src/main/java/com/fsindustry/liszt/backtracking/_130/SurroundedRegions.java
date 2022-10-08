package com.fsindustry.liszt.backtracking._130;

import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        char[][] board = {{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}};
        s.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
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

    private boolean isSurrounded(char[][] board, int x, int y, List<Point> path) {
        Queue<Point> q = new LinkedList<>();
        boolean res = true;
        visited[x][y] = true;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            path.add(new Point(cur.x, cur.y));

            for (int i = 0; i < 4; i++) {
                int newx = cur.x + move[i][0];
                int newy = cur.y + move[i][1];

                if (!inArea(newx, newy)) {
                    res = false;
                } else if (board[newx][newy] == 'O' && !visited[newx][newy]) {
                    visited[newx][newy] = true;
                    q.add(new Point(newx, newy));
                }
            }
        }
        return res;
    }

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (n == 0) {
            return;
        }

        visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 'O' && !visited[x][y]) {
                    List<Point> path = new ArrayList<>();
                    if (isSurrounded(board, x, y, path)) {
                        for (Point p : path) {
                            board[p.x][p.y] = 'X';
                        }
                    }
                }
            }
        }
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

    private boolean isSurrounded(char[][] board, int x, int y, List<Point> path) {

        visited[x][y] = true;
        path.add(new Point(x, y));

        boolean res = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + move[i][0];
            int newy = y + move[i][1];
            if (!inArea(newx, newy)) {
                res = false;
            } else if (board[newx][newy] == 'O' && !visited[newx][newy]) {
                if (!isSurrounded(board, newx, newy, path)) {
                    res = false;
                }
            }
        }

        return res;
    }

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (n == 0) {
            return;
        }

        visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 'O' && !visited[x][y]) {
                    List<Point> path = new ArrayList<>();
                    if (isSurrounded(board, x, y, path)) {
                        for (Point p : path) {
                            board[p.x][p.y] = 'X';
                        }
                    }
                }
            }
        }
    }
}