package com.fsindustry.liszt.algr.backtracking._79;

public class WordSearch {
}

class Solution {

    private int m, n;
    private boolean[][] visited;
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean findWord(char[][] board, String word, int idx, int x, int y) {
        if (idx == word.length() - 1) {
            return board[x][y] == word.charAt(idx);
        }

        if (board[x][y] == word.charAt(idx)) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int newx = x + move[i][0];
                int newy = y + move[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (findWord(board, word, idx + 1, newx, newy)) {
                        return true;
                    }
                }
            }

            visited[x][y] = false;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        if (n == 0) {
            return false;
        }

        visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (findWord(board, word, 0, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
