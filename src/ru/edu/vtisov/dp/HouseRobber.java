package ru.edu.vtisov.dp;

// https://leetcode.com/problems/house-robber/

public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = temp;
        }
        return Math.max(prevPrev, prev);
    }

    /*
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }
        return Math.max(memo[n - 1], memo[n - 2]);
    }
    */
}
