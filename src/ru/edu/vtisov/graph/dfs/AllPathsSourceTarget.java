// https://leetcode.com/problems/all-paths-from-source-to-target/

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        dfs(graph, paths, 0, new ArrayList<>());

        return paths;
    }

    private void dfs(int[][] graph, List<List<Integer>> paths, int node, List<Integer> current) {
        current.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(current));
            return;
        }

        int[] nextNodes = graph[node];
        for (int nextNode: graph[node]) {
            dfs(graph, paths, nextNode, current);
            current.remove(current.size() - 1);
        }
    }
}
