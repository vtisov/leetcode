// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = Math.abs(points[i][0] - points[j][0])
                    + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {weight, i, j});
            }
        }

        Collections.sort(edges, (x, y) -> Integer.compare(x[0], y[0]));
        
        UnionFind uf = new UnionFind(points.length);
        int edgesUsed = 0;
        int cost = 0;
        for (int[] edge: edges) {
            if (edgesUsed == points.length - 1) {
                return cost;
            }
            int weight = edge[0];
            int from = edge[1];
            int to = edge[2];
            if (uf.union(from, to)) {
                cost += weight;
                edgesUsed++;
            }
        }
        return cost;
    }
}

class UnionFind {

    private final int[] root;
    private final int[] rank;

    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }
}
