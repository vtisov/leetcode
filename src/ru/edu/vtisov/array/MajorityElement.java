package ru.edu.vtisov.array;

// https://leetcode.com/problems/majority-element/

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int vote = 0;
        for (int num: nums) {
            if (vote == 0) {
                candidate = num;
                vote++;
            } else if (num == candidate) {
                vote++;
            } else {
                vote--;
            }
        }
        return candidate;
    }

    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }
}