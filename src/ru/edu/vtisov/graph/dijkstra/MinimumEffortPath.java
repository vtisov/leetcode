// https://leetcode.com/problems/path-with-minimum-effort/

import java.util.*;

public class MinimumEffortPath {

    private final int[][] directions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] diffMatrix = new int[rows][cols];
        for (int[] array: diffMatrix) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        diffMatrix[0][0] = 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>((a1, a2) -> Integer
            .compare(a1.diff, a2.diff));

        queue.add(new Cell(0, 0, 0));

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            // Если это устаревшее состояние (больший diff чем уже найденный) — пропускаем
            if (curr.diff > diffMatrix[curr.x][curr.y]) continue;
            if (curr.x == rows - 1 && curr.y == cols - 1) {
                return curr.diff;
            }

            for (int[] dir: directions) {
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if (isValid(x, y, rows, cols)) {
                    int edgeDiff = Math.abs(heights[curr.x][curr.y] - heights[x][y]);
                    int max = Math.max(diffMatrix[curr.x][curr.y], edgeDiff);
                    if (diffMatrix[x][y] > max) {
                        diffMatrix[x][y] = max;
                        queue.add(new Cell(x, y, max));
                    }
                }
            }
        }
        return diffMatrix[rows - 1][cols - 1];
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    static class Cell {
        final int x;
        final int y;
        final int diff;

        public Cell(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
}
