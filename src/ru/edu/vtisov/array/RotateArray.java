package ru.edu.vtisov.array;

// https://leetcode.com/problems/rotate-array/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}