// https://leetcode.com/problems/all-paths-from-source-to-target

public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> first = new ArrayList<>();
        first.add(0);
        queue.offer(first);

        while(!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int last = current.get(current.size() - 1);
            if (last == graph.length - 1) {
                paths.add(new ArrayList<>(current));
                continue;
            }

            for (int node: graph[last]) {
                List<Integer> next = new ArrayList(current);
                next.add(node);
                queue.offer(next);
            }
        }

        return paths;
    }
}
