package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/combination-sum-ii/

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> comb = new LinkedList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (!counter.containsKey(candidate)) counter.put(candidate, 0);
            counter.put(candidate, counter.get(candidate) + 1);
        }

        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[]{key, value});
        });
        backtrack(comb, target, 0, counterList, results);
        return results;
    }

    private void backtrack(List<Integer> combinations,
                           int remain,
                           int current,
                           List<int[]> counter,
                           List<List<Integer>> results) {
        if (remain == 0) results.add(new ArrayList<Integer>(combinations));
        if (remain <= 0) return;
        
        for (int next = current; next < counter.size(); next++) {
            int[] entry = counter.get(next);
            int candidate = entry[0];
            int count = entry[1];

            if (count <= 0) continue;

            combinations.add(candidate);
            counter.set(next, new int[]{candidate, count - 1});

            backtrack(combinations, remain - candidate, next, counter, results);

            counter.set(next, new int[]{candidate, count});
            combinations.remove(combinations.size() - 1);
        }
    }
}