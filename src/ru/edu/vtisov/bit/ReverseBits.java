package ru.edu.vtisov.bit;

// https://leetcode.com/problems/reverse-bits/

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 31; i >= 0; i--) {
            int current = (n >> i) & 1;
            answer += (current << (31 - i));
        }
        return answer;
    }
}