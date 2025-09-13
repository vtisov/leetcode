// https://leetcode.com/problems/graph-valid-tree/

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind {

    private int[] root;
    private int[] rank;

    UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }

    public boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return false;
        }
        if (rank[xParent] < rank[yParent]) {
            this.root[xParent] = yParent;
        } else if (rank[yParent] < rank[xParent]) {
            this.root[yParent] = xParent;
        } else {
            this.root[yParent] = xParent;
            this.rank[xParent] += 1;
        }
        return true;
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
}

/*
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        stack.add(0);
        seen.add(0);

        while(stack.size() != 0) {
            int node = stack.removeFirst();
            for (int neighbour: adjacencyList.get(node)) {
                if (seen.contains(neighbour)) {
                    continue;
                }
                stack.add(neighbour);
                seen.add(neighbour);
            }
            
        }
        return seen.size() == n;
    }
}
*/

/*
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        stack.add(0);
        parent.put(0, -1);

        while(stack.size() != 0) {
            int node = stack.removeFirst();
            for (int neighbour: adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) { 
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                stack.add(neighbour);
                parent.put(neighbour, node);
            }
        }
        return parent.size() == n;
    }
}
*/

/*
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        stack.add(0);
        seen.add(0);

        while(stack.size() != 0) {
            int node = stack.removeFirst();
            for (int neighbour: adjacencyList.get(node)) {
                if (seen.contains(neighbour)) {
                    return false;
                }
                stack.add(neighbour);
                seen.add(neighbour);
                adjacencyList.get(neighbour).remove((Integer) node); // (1)
            }
            
        }

        return seen.size() == n;
    }
}
*/
