package ru.edu.vtisov.array;

// https://leetcode.com/problems/majority-element-ii

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;

        for (int num: nums) {
            if (num == candidate1) {
                vote1++;
            } else if (num == candidate2) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1 = 1;
            } else if (vote2 == 0) {
                candidate2 = num;
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }

        vote1 = 0;
        vote2 = 0;

        for (int num: nums) {
            if (num == candidate1) vote1++;
            else if (num == candidate2) vote2++;
        }

        List<Integer> result = new ArrayList<>();
        if (vote1 > nums.length / 3) result.add(candidate1);
        if (vote2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}