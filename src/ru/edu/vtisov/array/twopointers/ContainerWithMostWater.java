package ru.edu.vtisov.array.twopointers;

// https://leetcode.com/problems/container-with-most-water

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
}