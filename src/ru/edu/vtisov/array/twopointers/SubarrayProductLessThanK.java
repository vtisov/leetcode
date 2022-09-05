package ru.edu.vtisov.array.twopointers;

// https://leetcode.com/problems/subarray-product-less-than-k/

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1;
        int answer = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            answer += right - left + 1;
        }
        return answer;
    }
}