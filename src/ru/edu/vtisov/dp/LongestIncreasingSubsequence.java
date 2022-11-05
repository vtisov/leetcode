package ru.edu.vtisov.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current > sub.get(sub.size() - 1)) {
                sub.add(current);
            } else {
                int j = binarySearch(sub, current);
                sub.set(j, current);
            }
            
        }
        return sub.size();
    }
    
    private int binarySearch(List<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) return mid;
            if (sub.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}