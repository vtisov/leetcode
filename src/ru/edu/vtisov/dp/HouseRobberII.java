package ru.edu.vtisov.dp;

// https://leetcode.com/problems/house-robber-ii
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max1 = simpleRob(nums, 0, nums.length - 1);
        int max2 = simpleRob(nums, 1, nums.length);
        return Math.max(max1, max2);
    }

    // [t1=0, t2=0, 7, 4, 1, 9, 3, 8, 6, 5]
    public int simpleRob(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;
        for (int i = start; i < end; i++) {
            int temp = t2;
            t2 = Math.max(t2, t1 + nums[i]);
            t1 = temp;
        }
        return t2;
    }
}