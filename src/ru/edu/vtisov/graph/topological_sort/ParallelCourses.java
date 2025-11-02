package ru.edu.vtisov.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/parallel-courses

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int[] count = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < relations.length; i++) {
            graph.get(relations[i][0]).add(relations[i][1]);
            count[relations[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int node = 1; node < count.length; node++) {
            if (count[node] == 0) {
                queue.add(node);
            }
        }

        int step = 0;
        int coursesLearned = 0;

        while(!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            step++;
            while(!queue.isEmpty()) {
                coursesLearned++;
                int current = queue.remove();
                for(int node: graph.get(current)) {
                    count[node]--;
                    if (count[node] == 0) {
                        next.add(node);
                    }
                } 
            }
            queue = next;
        }

        return coursesLearned == n ? step : -1;
    }
}
