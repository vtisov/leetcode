package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/

public class SubsetsII {
    
    private final List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0 , new ArrayList<>());
        return result;
    }
    
    private void backtracking(int[] nums, int start, List<Integer> current) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(nums, i + 1, current);
            current.remove(current.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }
}