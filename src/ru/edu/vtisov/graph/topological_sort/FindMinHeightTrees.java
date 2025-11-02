// https://leetcode.com/problems/minimum-height-trees

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }


        List<Set<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) {
                queue.add(i);
            }
        }

        int remains = n;
        while (remains > 2) {
            remains -= queue.size();
            Queue<Integer> next = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbour: adj.get(node)) {
                    adj.get(neighbour).remove(node);
                    if (adj.get(neighbour).size() == 1) {
                        next.add(neighbour);
                    }
                }
            }
            queue = next;
        }
        return new ArrayList<>(queue);
    }
}
