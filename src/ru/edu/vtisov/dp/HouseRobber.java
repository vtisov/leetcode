package ru.edu.vtisov.dp;

// https://leetcode.com/problems/house-robber/

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        nums[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
        }
        return Math.max(nums[n - 1], nums[n - 2]);
    }
}