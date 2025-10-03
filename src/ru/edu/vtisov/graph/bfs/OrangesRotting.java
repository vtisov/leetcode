// https://leetcode.com/problems/rotting-oranges/

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][] {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
        };

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                for (int[] d : dirs) {
                    int x = cx + d[0];
                    int y = cy + d[1];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;

                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }

            // если в очереди остались новые элементы → будет ещё один раунд → увеличиваем время
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return isRotten(grid) ? minutes : -1;
    }

    private boolean isRotten(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
