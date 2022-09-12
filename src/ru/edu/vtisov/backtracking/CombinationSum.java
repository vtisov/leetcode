package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/

public class CombinationSum {
    
    private final List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, new ArrayList<>(), 0, 0, target);
        return result;
    }
    
    private void backtracking(int[] candidates, List<Integer> path, int sum, int start, int target) {
        if (sum == target) result.add(new ArrayList<>(path));
        if (sum > target) return;
        
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, path, sum + candidates[i], i, target);
            path.remove(path.size() - 1);
        }
    }
}