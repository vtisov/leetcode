package ru.edu.vtisov.tree.dfs;

// https://leetcode.com/problems/the-maze

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] current, int[] destination) {
        int x = current[0];
        int y = current[1];

        if (visited[x][y]) {
            return false;
        }

        if (x == destination[0] && y == destination[1]) {
            return true;
        }

        visited[x][y] = true;

        int n = maze.length;
        int m = maze[0].length;
        int[] moveX = new int[]{0, 0, -1, 1};
        int[] moveY = new int[]{1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int curX = x;
            int curY = y;
            while (curX >= 0 && curX < n && curY >= 0 && curY < m && maze[curX][curY] == 0) {
                curX += moveX[i];
                curY += moveY[i];
            }

            // Revert the last move to get the cell to which the ball rolls.
            if (dfs(maze, visited, new int[]{curX -= moveX[i], curY -= moveY[i]}, destination)) {
                return true;
            }
        }
        return false;
    }

}

/* bfs
public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visit[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int r = curr[0];
                int c = curr[1];
                // Move the ball in the chosen direction until it can.
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += dirX[i];
                    c += dirY[i];
                }
                // Revert the last move to get the cell to which the ball rolls.
                r -= dirX[i];
                c -= dirY[i];
                if (!visit[r][c]) {
                    queue.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }
        return false;
    }
}
*/