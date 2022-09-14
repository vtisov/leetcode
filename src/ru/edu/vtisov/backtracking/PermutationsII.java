package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    
    private final List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }
        backtracking(counter, new ArrayList<>(), nums.length);
        return result;
    }
    
    private void backtracking(Map<Integer, Integer> counter, List<Integer> current, int n) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 0) continue;
            current.add(num);
            counter.put(num, count - 1);
            backtracking(counter, current, n);
            current.remove(current.size() - 1);
            counter.put(num, count);
        }
    }
}