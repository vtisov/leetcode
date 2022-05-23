package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations/

public class Permutations {

    private final List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return results;
    }

    private void backtrack(int[] nums, int n) {
        if (n == nums.length) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = n; i < nums.length; i++) {
            swap(nums, n, i);
            backtrack(nums, n + 1);
            swap(nums, n, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}