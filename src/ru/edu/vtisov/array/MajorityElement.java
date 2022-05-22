package ru.edu.vtisov.array;

// https://leetcode.com/problems/majority-element/

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = 0;
        int vote = 0;
        for (int num: nums) {
            if (vote == 0) {
                result = num;
                vote++;
            } else if (result == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return result;
    }

    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }
}