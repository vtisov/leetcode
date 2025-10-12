// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        heap.add(new int[] {0, 0});
        int edgesUsed = 0;
        int cost = 0;

        while (edgesUsed != points.length) {
            int[] current = heap.poll();
            int weight = current[0];
            int next = current[1];

            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            cost += weight;
            edgesUsed++;

            for (int i = 0; i < points.length; i++) {
                heap.add(new int[] {
                    Math.abs(points[next][0] - points[i][0])
                        + Math.abs(points[next][1] - points[i][1]),
                    i
                });
            }
        }
        
        return cost;
    }
}
