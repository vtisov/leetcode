package ru.edu.vtisov.tree.dfs;

public class  MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, visitArea(grid, i, j));
            }
        }
        return max;
    }

    public int visitArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == -1 || grid[i][j] == 0) return 0;
        grid[i][j] = -1;
        return 1 + visitArea(grid, i - 1, j)
                + visitArea(grid, i + 1, j)
                + visitArea(grid, i, j - 1)
                + visitArea(grid, i, j + 1);
    }
}