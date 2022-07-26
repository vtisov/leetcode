package ru.edu.vtisov.array;

// https://leetcode.com/problems/move-zeroes/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length - 1;
        while (i < n && j < n) {
            while(nums[i] != 0 && i < n) i++;
            j = i;
            while(nums[j] == 0 && j < n) j++;
            swap(nums, i, j);
        }
    }

    // public void moveZeroes(int[] nums) {
    //     for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
    //         if (nums[cur] != 0) {
    //             swap(nums, lastNonZeroFoundAt++, cur);
    //         }
    //     }
    // }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}