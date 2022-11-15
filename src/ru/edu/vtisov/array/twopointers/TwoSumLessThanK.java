package ru.edu.vtisov.array.twopointers;

// https://leetcode.com/problems/two-sum-less-than-k

public class TwoSumLessThanK {
    
    // counting sort
    public int twoSumLessThanK(int[] nums, int k) {
        int sum = -1;
        int[] count = new int[1001];
        for (int num : nums) count[num]++;
        int i = 1;
        int j = 1000;
        while (i <= j) {
            int current = i + j;
            if (current >= k || count[j] == 0) {
                j--;
            } else {
                if (count[i] > (i == j ? 1 : 0)) {
                    sum = Math.max(sum, current);
                }
                i++;
            }
        }
        return sum;
    }

     /* two pointers
     public int twoSumLessThanK(int[] nums, int k) {
         Arrays.sort(nums);
         int sum = -1;
         int i = 0;
         int j = nums.length - 1;
         while (i < j) {
             int current = nums[i] + nums[j];
             if (current < k) {
                 sum = Math.max(sum, current);
                 i++;
             } else {
                 j--;
             }
         }
         return sum;
     }*/
}