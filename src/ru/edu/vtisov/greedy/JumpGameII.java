package ru.edu.vtisov.greedy;

// https://leetcode.com/problems/jump-game-ii

public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0;
        int timeToJump = 0;
        int farthest = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == timeToJump) {
                jumps++;
                timeToJump = farthest;
            }
        }
        return jumps;
    }
}
