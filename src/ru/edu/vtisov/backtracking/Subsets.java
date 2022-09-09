package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/

public class Subsets {

    private final List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return results;
    }

    private void backtracking(int[] nums,
                              int start,
                              List<Integer> current) {
        results.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}