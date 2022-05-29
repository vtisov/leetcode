package ru.edu.vtisov.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dep = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for(int[] course: prerequisites) {
            dep.putIfAbsent(course[1], new ArrayList<>());
            dep.get(course[1]).add(course[0]);

            counter.putIfAbsent(course[0], 0);
            counter.put(course[0], counter.get(course[0]) + 1);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int current: dep.keySet()) {
            if (!counter.containsKey(current))
                queue.add(current);
        }

        while(!queue.isEmpty()) {
            int current = queue.removeFirst();
            for(int course: dep.getOrDefault(current, new ArrayList<>())) {
                counter.put(course, counter.get(course) - 1);
                if(counter.get(course) == 0) {
                    queue.add(course);
                }
            }
        }

        for(int count: counter.values()) {
            if (count > 0) return false;
        }
        return true;
    }
}