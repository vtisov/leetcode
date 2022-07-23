package ru.edu.vtisov.graph;

import java.util.*;

// https://leetcode.com/problems/course-schedule/

public class CourseSchedule {

    private final Map<Integer, List<Integer>> dep = new HashMap<>();
    private final Map<Integer, String> marks = new HashMap<>();

    // Tarjan's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] course: prerequisites) {
            dep.putIfAbsent(course[1], new ArrayList<>());
            dep.get(course[1]).add(course[0]);
        }

        for(int next: dep.keySet()) {
            if (!dfs(next)) return false;
        }
        return true;
    }

    private boolean dfs(int node) {
        String mark = marks.getOrDefault(node, "no_color");
        if (mark.equals("permanent")) return true;
        if (mark.equals("temp")) return false;

        marks.put(node, "temp");
        for(int next: dep.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(next)) return false;
        }
        marks.put(node, "permanent");
        return true;
    }

}

//public class CourseSchedule {
//
//    // Kahn algorithm
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> dep = new HashMap<>();
//        Map<Integer, Integer> counter = new HashMap<>();
//
//        for(int[] course: prerequisites) {
//            dep.putIfAbsent(course[1], new ArrayList<>());
//            dep.get(course[1]).add(course[0]);
//
//            counter.putIfAbsent(course[0], 0);
//            counter.put(course[0], counter.get(course[0]) + 1);
//        }
//
//        LinkedList<Integer> queue = new LinkedList<>();
//        for (int current: dep.keySet()) {
//            if (!counter.containsKey(current))
//                queue.add(current);
//        }
//
//        while(!queue.isEmpty()) {
//            int current = queue.removeFirst();
//            for(int course: dep.getOrDefault(current, new ArrayList<>())) {
//                counter.put(course, counter.get(course) - 1);
//                if(counter.get(course) == 0) {
//                    queue.add(course);
//                }
//            }
//        }
//
//        for(int count: counter.values()) {
//            if (count > 0) return false;
//        }
//        return true;
//    }
//}