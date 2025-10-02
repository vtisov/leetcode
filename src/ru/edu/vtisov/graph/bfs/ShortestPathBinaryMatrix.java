// https://leetcode.com/problems/shortest-path-in-binary-matrix/

public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int[][] pos = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };


        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[] {0, 0});
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x < 0 || y < 0 || x >= n || y>= n) {
                    continue;
                }
                if (x == n - 1 && y == n - 1) {
                    return count;
                }
                if (grid[x][y] == 1) {
                    continue;
                }
                grid[x][y] = 1;
                for (int[] p: pos) {
                    queue.add(new int[]{current[0] + p[0], current[1] + p[1]});
                }
            }
            count++;
        }
        return -1;
    }
}
