package ru.edu.vtisov.stack;

import java.util.Stack;

// https://leetcode.com/problems/number-of-valid-subarrays

public class NumberOfValidSubarrays {
    public int validSubarrays(int[] nums) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                answer += i - stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer += nums.length - stack.pop();
        }
        return answer;
    }
}