package ru.edu.vtisov.array;

import java.util.Arrays;
import java.util.Random;

// https://leetcode.com/problems/shuffle-an-array

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class ShuffleAnArray {
    private int[] array;
    private int[] original;
    private Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        array = original;
        original = Arrays.copyOf(original, original.length);
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(array, i, randRange(i, array.length));
        }
        return array;
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
}
