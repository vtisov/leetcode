// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        stack.push(source);

        while(stack.size() != 0) {
            int current = stack.pop();
            if (current == destination) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for (int next: graph.get(current)) {
                stack.push(next);
            }
        }
        return false;
    }
}

// class Solution {


//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         Set<Integer> visited = new HashSet<>();
//         Map<Integer, List<Integer>> adj = new HashMap<>();

//         for(int[] edge: edges) {
//             adj.putIfAbsent(edge[0], new ArrayList<>());
//             adj.putIfAbsent(edge[1], new ArrayList<>());
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]);
//         }

//         return dfs(visited, adj, source, destination);
//     }

//     private boolean dfs(Set<Integer> visited, Map<Integer, List<Integer>> adj, int current, int destination) {
//         if (current == destination) {
//             return true;
//         }
//         if (visited.contains(current)) {
//             return false;
//         }
//         visited.add(current);
//         for (int next: adj.get(current)) {
//             if (dfs(visited, adj, next, destination)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
