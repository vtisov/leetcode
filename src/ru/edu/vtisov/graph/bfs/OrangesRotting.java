// https://leetcode.com/problems/rotting-oranges/

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int[][] pos = new int[][] {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
        };

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        var count = 0;

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var current = queue.poll();                
                grid[current.getKey()][current.getValue()] = 2;
                for (int[] p: pos) {
                    var x = current.getKey() + p[0];
                    var y = current.getValue() + p[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols
                        || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        queue.add(new Pair<>(x, y));
                        grid[x][y] = 2;
                    }
                }
            }
            if (!queue.isEmpty()) {
                count++;
            }
        }
        return isRotten(grid) ? count : -1;
    }

    private boolean isRotten(int[][] grid) {
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
