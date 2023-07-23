package ru.edu.vtisov.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// https://leetcode.com/problems/fruit-into-baskets/

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int result = 0;
        int left = 0;
        int k = 2;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            int current = fruits[right];
            if (!counter.containsKey(current)) counter.put(current, 0);
            counter.put(current, counter.get(current) + 1);
            while(counter.size() > k) {
                int left_value = fruits[left];
                counter.put(left_value, counter.get(left_value) - 1);
                if (counter.get(left_value) == 0)
                    counter.remove(left_value);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}