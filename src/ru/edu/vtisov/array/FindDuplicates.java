package ru.edu.vtisov.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num: nums) {
            if (nums[Math.abs(num) - 1] < 0)
                result.add(Math.abs(num));
            nums[Math.abs(num) - 1] *= -1;
        }
        return result;
    }
}