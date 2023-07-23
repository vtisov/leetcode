package ru.edu.vtisov.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : arr) frequency.merge(num, 1, Integer::sum);
        Set<Integer> frequencySet = new HashSet<>(frequency.values());
        return frequency.size() == frequencySet.size(); 
    }
}