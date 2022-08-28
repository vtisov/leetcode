package ru.edu.vtisov.bit;

// https://leetcode.com/problems/power-of-two/

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == Integer.MIN_VALUE) return false;
        return n != 0 && (n & n - 1) == 0;
    }
}