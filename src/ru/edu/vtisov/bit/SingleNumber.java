package ru.edu.vtisov.bit;

// https://leetcode.com/problems/single-number/

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int mask = 0;
        for (int i: nums)
            mask ^= i;
        return mask;
    }
}