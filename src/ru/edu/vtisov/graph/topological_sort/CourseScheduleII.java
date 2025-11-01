// https://leetcode.com/problems/course-schedule-ii

public class CourseScheduleII {
  
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] req: prerequisites) {
            var src = req[1];
            var dst = req[0];
            adj.putIfAbsent(src, new ArrayList<>());
            var list = adj.get(src);
            list.add(dst);
            inDegree[dst]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int i = 0;
        int[] topologicalOrder = new int[numCourses];
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            topologicalOrder[i++] = curr;
            var list = adj.getOrDefault(curr, new ArrayList<>());
            for (int elem : list) {
                inDegree[elem]--;
                if (inDegree[elem] == 0) queue.add(elem);
            }
        }

        if (i == numCourses) return topologicalOrder;

        return new int[0];
    }
}
