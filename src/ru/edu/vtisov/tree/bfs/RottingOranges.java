package ru.edu.vtisov.tree.bfs;

// https://leetcode.com/problems/rotting-oranges/

import java.util.HashSet;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<Pair<Integer, Integer>> queue = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.add(new Pair(i, j));
            }
        }
        if (queue.isEmpty()) {
            return rotted(grid) ? 0 : -1;
        }
        int count = -1;
        while (!queue.isEmpty()) {
            Set<Pair<Integer, Integer>> temp = new HashSet<>();
            for (Pair<Integer, Integer> current: queue) {
                int i = current.getKey();
                int j = current.getValue();
                grid[i][j] = 2;
                temp.remove(new Pair(i, j));
                if (isFresh(grid, i - 1, j)) temp.add(new Pair(i - 1, j));
                if (isFresh(grid, i + 1, j)) temp.add(new Pair(i + 1, j));
                if (isFresh(grid, i, j - 1)) temp.add(new Pair(i, j - 1));
                if (isFresh(grid, i, j + 1)) temp.add(new Pair(i, j + 1));
            }
            queue = temp;
            count++;
            // if (rotted(grid)) return count;
        }
        return rotted(grid) ? count : -1;

    }

    private boolean isFresh(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return false;
        return true;
    }

    private boolean rotted(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }
}