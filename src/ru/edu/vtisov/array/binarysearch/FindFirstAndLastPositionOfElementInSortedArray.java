package ru.edu.vtisov.array.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int second = binarySearch(nums, target, false);
        return new int[] {first, second};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (isLeft) end = mid - 1;
                else start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}