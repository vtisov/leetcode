package ru.edu.vtisov.tree.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/minimum-genetic-mutation

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        Queue<String> seen = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] chars = new char[] {'A', 'C', 'G', 'T'};
        
        queue.add(start);
        seen.add(start);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String cur = queue.remove();
                if (cur.equals(end)) return steps;
                
                for (int j = 0; j < cur.length(); j++) {
                    for (char c : chars) {
                        String next = cur.substring(0, j) + c + cur.substring(j + 1);
                        if (!seen.contains(next) && bankSet.contains(next)) {
                            seen.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}