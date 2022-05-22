package ru.edu.vtisov.array;

// https://leetcode.com/problems/maximum-subarray/

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            sum = Math.max(sum, num);
            max = Math.max(max, sum);
        }
        return max;
    }
}