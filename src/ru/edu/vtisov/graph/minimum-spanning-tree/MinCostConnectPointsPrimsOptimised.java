// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int costMst = 0;
        int edgesVisited = 0;
        int[] visited = new int[n];
        int[] minEdges = new int[n];

        for (int i = 0; i < n; i++) {
            minEdges[i] = Integer.MAX_VALUE;
        }

        minEdges[0] = 0;

        while (edgesVisited < n) {
            int currentNode = -1;
            int currentCost = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && minEdges[i] < currentCost) {
                    currentNode = i;
                    currentCost = minEdges[i];
                }
            }
            visited[currentNode] = 1;
            edgesVisited++;
            costMst += currentCost;
            for (int i = 0; i < n; i++) {
                int weight = Math.abs(points[i][0] - points[currentNode][0]) 
                        + Math.abs(points[i][1] - points[currentNode][1]);
                if (visited[i] == 0 && weight < minEdges[i]) {
                    minEdges[i] = weight;
                }
            }
        }
        return costMst;
    }
}
