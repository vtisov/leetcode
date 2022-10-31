package ru.edu.vtisov.dp;

// https://leetcode.com/problems/arithmetic-slices

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) sum += ++dp;
            else dp = 0;
        }
        return sum;
    }
}