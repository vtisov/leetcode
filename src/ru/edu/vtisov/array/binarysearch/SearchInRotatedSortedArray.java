package ru.edu.vtisov.array.binarysearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length, target);
        }
        
        if (nums[pivot] == target) {
            return pivot;
        }
    
        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot, target);
        }
        return binarySearch(nums, pivot + 1, nums.length, target);
    }
    
    private int findPivot(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;    
            }
        }
        return -1;
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {        
        int i = start;
        int j = end - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) j = mid - 1;
            if (target > nums[mid]) i = mid + 1;
        }
        return -1; 
    }
}