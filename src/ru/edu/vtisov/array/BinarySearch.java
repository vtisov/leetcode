package ru.edu.vtisov.array;

// https://leetcode.com/problems/binary-search/

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    private int binary(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left)/2;
        if (nums[mid] == target) return mid;
        if (target < nums[mid]) return binary(nums, target, left, mid - 1);
        else return binary(nums, target, mid + 1, right);
    }
}