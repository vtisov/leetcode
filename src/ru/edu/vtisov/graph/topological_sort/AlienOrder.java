// https://leetcode.com/problems/alien-dictionary/

public class AlienOrder {
  
    public String alienOrder(String[] words) {
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }


        // build graph and count inDegree
        for (int i = 1; i < words.length; i++) {
            var w1 = words[i - 1];
            var w2 = words[i];
            var min = Math.min(w1.length(), w2.length());
            var found = false;
            for (int j = 0; j < min; j++) {
                var c1 = w1.charAt(j);
                var c2 = w2.charAt(j);
                if (c1 != c2) {
                    found = true;
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
            if (!found && w1.length() > w2.length()) {
                return ""; // have to "abc" < "ab"
            }
        }

        // topological sort
        Queue<Character> queue = new ArrayDeque<>();
        for (var entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        var result = new StringBuilder();
        while (!queue.isEmpty()) {
            var node = queue.poll();
            result.append(node);
            for (var c : graph.getOrDefault(node, new HashSet<>())) {
                var count = inDegree.get(c);
                count--;
                inDegree.put(c, count);
                if (count == 0) {
                    queue.add(c);
                }
            }

        }

        if (graph.size() != result.toString().length()) {
            return "";
        }

        return result.toString();
    }
}
