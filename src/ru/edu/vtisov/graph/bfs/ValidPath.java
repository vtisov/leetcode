// https://leetcode.com/problems/find-if-path-exists-in-graph/

public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        queue.offer(source);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for(int node: graph.get(current)) {
                queue.offer(node);
            }
        }

        return false;
    }
}
