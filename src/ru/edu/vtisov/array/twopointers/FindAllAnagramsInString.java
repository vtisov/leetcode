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

//public class Solution {
//
//    private final Map<Character, Integer> pattern = new HashMap<>();
//
//    public boolean indexOf(String str, String substring) {
//        for (int i = 0; i < substring.length(); i++) {
//            increment(substring.charAt(i));
//        }
//
//        for (int i = 0; i < substring.length(); i++) {
//            decrement(str.charAt(i));
//        }
//
//        for (int i = 0, j = substring.length(); j < str.length();) {
//            if (pattern.size() == 0) return i;
//            decrement(str.charAt(i++));
//            increment(str.charAt(++j));
//        }
//        return -1;
//    }
//
//    private void increment(char c) {
//        pattern.putIfAbsent(c, 0);
//        pattern.put(c, pattern.get(c) + 1);
//    }
//
//    private void decrement(char c) {
//        pattern.putIfAbsent(c, 0);
//        pattern.put(c, pattern.get(c) - 1);
//        if (pattern.get(c) == 0) {
//            pattern.remove(c);
//        }
//    }
//
//}