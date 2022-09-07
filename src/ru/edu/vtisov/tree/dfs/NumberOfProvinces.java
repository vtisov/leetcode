
package ru.edu.vtisov.tree.dfs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int sum = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                sum++;
                dfs(isConnected, visited, i);
            }
            
        }
        return sum;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}