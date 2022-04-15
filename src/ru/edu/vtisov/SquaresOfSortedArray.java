package ru.edu.vtisov;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = (int) Math.pow(nums[left++], 2);
            } else {
                result[i] = (int) Math.pow(nums[right--], 2);
            }
        }
        return result;
    }
}