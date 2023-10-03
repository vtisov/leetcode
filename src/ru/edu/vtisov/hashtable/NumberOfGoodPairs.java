package ru.edu.vtisov.hashtable;

// https://leetcode.com/problems/number-of-good-pairs/

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer += count.getOrDefault(nums[i], 0);
            count.merge(nums[i], 1, Integer::sum);
        }
        return answer;
    }

//    public int numIdenticalPairs(int[] nums) {
//        int[] map = new int[101];
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += map[nums[i]];
//            map[nums[i]]++;
//        }
//        return sum;
//    }

}