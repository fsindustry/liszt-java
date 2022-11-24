package com.fsindustry.liszt.algr.backtracking._37;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
}

class Solution {
    private boolean find = false;
    private List<Point> spaces = new ArrayList<>();

    private boolean[][] line = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfs(char[][] board, int idx) {
        if (spaces.size() == idx) {
            find = true;
            return;
        }

        Point cur = spaces.get(idx);
        for (int i = 0; i < 9 && !find; i++) {
            if (!line[cur.x][i] && !col[cur.y][i] && !block[cur.x / 3][cur.y / 3][i]) {
                line[cur.x][i] = true;
                col[cur.y][i] = true;
                block[cur.x / 3][cur.y / 3][i] = true;
                board[cur.x][cur.y] = (char) (i + '0' + 1);

                dfs(board, idx + 1);

                line[cur.x][i] = false;
                col[cur.y][i] = false;
                block[cur.x / 3][cur.y / 3][i] = false;
            }
        }
    }

    public void solveSudoku(char[][] board) {

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] == '.') {
                    spaces.add(new Point(x, y));
                } else {
                    int digit = board[x][y] - '0' - 1;
                    line[x][digit] = true;
                    col[y][digit] = true;
                    block[x / 3][y / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }
}
