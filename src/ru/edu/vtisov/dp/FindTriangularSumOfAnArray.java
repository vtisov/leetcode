package ru.edu.vtisov.dp;

// https://leetcode.com/problems/find-triangular-sum-of-an-array

public class FindTriangularSumOfAnArray {

    // in place
    // [1, 2, 3, 4, 5], i = 4
    // [3, 5, 7, 9, -], i = 3
    // [8, 2, 6, -, -], i = 2
    // [0, 8, -, -, -], i = 1
    // [8, -, -, -, -], i = 0
    public int triangularSum(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++)
                nums[j] = (nums[j] + nums[j + 1]) % 10;
        return nums[0];
    }

    // solution with temp array
    // public int triangularSum(int[] nums) {
    //     while (nums.length != 1) {
    //         int[] temp = new int[nums.length - 1];
    //         for (int i = 0; i < temp.length; i++) {
    //             temp[i] = (nums[i] + nums[i + 1]) % 10;
    //         }
    //         nums = temp;
    //     }
    //     return nums[0];
    // }
}