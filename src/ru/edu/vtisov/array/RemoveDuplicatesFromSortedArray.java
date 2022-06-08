package ru.edu.vtisov.array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] = 101;
                count--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while(j < nums.length && nums[j] == 101) {
                j++;
            }
            if (i != j && j < nums.length) swap(nums, i, j);
        }
        return count;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}