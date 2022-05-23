package ru.edu.vtisov.bit;

// https://leetcode.com/problems/counting-bits/

public class CountBits {
    public int[] countBits(int n) {
        int[] sum = new int[n + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i >> 1] + (i % 2);
        }
        return sum;
    }
}