public class EarliestAcq {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        for (int[] log: logs) {
            uf.union(log[1], log[2]);
            if (uf.count == 1) {
                return log[0];
            }
        }
        return -1;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return;
        }
        if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else if (rank[yParent] < rank[xParent]) {
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent] += 1;
        }
        count--;
    }
}
