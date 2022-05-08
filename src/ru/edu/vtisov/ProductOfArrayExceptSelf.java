package ru.edu.vtisov;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int right = 1;
        int[] answers = new int[n];
        Arrays.fill(answers, 1);
        for (int i = 1; i < n; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            answers[i] = answers[i] * right;
            right *= nums[i];
        }
        return answers;
    }

    // public int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] left = new int[n];
    //     int[] right = new int[n];
    //     int[] answers = new int[n];
    //     Arrays.fill(left, 1);
    //     Arrays.fill(right, 1);
    //     for (int i = 1; i < n; i++) {
    //         left[i] = left[i - 1] * nums[i - 1];
    //     }
    //     for (int i = n - 2; i >= 0; i--) {
    //         right[i] = right[i + 1] * nums[i + 1];
    //     }
    //     for (int i = 0; i < n; i++) {
    //         answers[i] = left[i] * right[i];
    //     }
    //     return answers;
    // }
}