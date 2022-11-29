package ru.edu.vtisov.backtracking;

// https://leetcode.com/problems/word-search

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        if (board[i][j] != word.charAt(pos)) return false;
        
        char current = board[i][j];
        board[i][j] = '#';
        boolean result = false;
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if(dfs(board, word, i + rowOffsets[d], j + colOffsets[d], pos + 1)) return true;
        }
        board[i][j] = current;
        return false;
    }
}