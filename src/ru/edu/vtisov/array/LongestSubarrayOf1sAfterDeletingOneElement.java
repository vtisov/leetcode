package ru.edu.vtisov.array;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

/* [1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1]
    ------------- previousSum
    ----------------------------- sum
                     ------------ previousSum
                     ----------------------- sum
*/
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int sum = 0;
        int result = 0;
        int previousSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= previousSum;
                previousSum = sum;
            } else {
                sum += 1;
                result = Math.max(sum, result);
            }
        }
        // handle corner case when all of elements are 1. we need to remove one of them by task
        return result == nums.length ? result - 1 : result;
    }
}