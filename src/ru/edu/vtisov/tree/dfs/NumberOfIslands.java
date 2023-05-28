package ru.edu.vtisov.tree.dfs;

// https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void visitIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        visitIsland(grid, i + 1, j);
        visitIsland(grid, i - 1, j);
        visitIsland(grid, i, j + 1);
        visitIsland(grid, i, j - 1);
    }
}
