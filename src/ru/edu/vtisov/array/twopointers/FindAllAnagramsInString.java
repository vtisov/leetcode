package ru.edu.vtisov.array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pattern = new int[26];
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();
        
        for (char c: p.toCharArray()) pattern[c - 'a']++;
        
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            
            if(i < p.length() - 1) continue;
            
            if (Arrays.equals(pattern, chars)) result.add(i - p.length() + 1);
            
            chars[s.charAt(i - p.length() + 1) - 'a']--;
        }
        return result;
    }
}