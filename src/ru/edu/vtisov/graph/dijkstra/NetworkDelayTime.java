// https://leetcode.com/problems/network-delay-time

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time: times) {
            var from = time[0];
            var to = time[1];
            var weight = time[2];
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new int[] {to, weight});
        }

        int[] mins = new int[n + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        mins[k] = 0;
        dijkstra(mins, adj, k);

        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, mins[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void dijkstra(int[] mins, Map<Integer, List<int[]>> adj, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
        Set<Integer> visited = new HashSet<>();
        heap.add(new int[] {k, 0});

        while (!heap.isEmpty()) {
            var current = heap.remove();
            var node = current[0];
            var weight = current[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            if (mins[node] < weight) {
                continue;
            }

            for (int[] pair: adj.getOrDefault(node, new ArrayList<>())) {
                var next = pair[0];
                var newWeight = pair[1] + weight;
                if (newWeight < mins[next]) {
                    mins[next] = newWeight;
                    heap.add(new int[] {next, newWeight});
                }
            }
        }
    }
}
