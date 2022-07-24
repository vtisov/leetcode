package ru.edu.vtisov.array;

// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) return nums.length;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < target) left = pivot + 1;
            else right = pivot;
        }
        return left;
    }
}