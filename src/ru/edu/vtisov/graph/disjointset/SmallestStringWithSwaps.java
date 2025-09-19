public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair: pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int parent = uf.find(vertex);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(vertex);
        }

        char[] result = new char[s.length()];
        for (List<Integer> current: map.values()) {
            List<Character> chars = new ArrayList<>();
            for (int c: current) {
                chars.add(s.charAt(c));
            }
            Collections.sort(chars);
            for (int i = 0; i < current.size(); i++) {
                result[current.get(i)] = chars.get(i);
            }
        }
        return new String(result);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
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
            parent[xParent] = yParent;
            rank[yParent] += 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
