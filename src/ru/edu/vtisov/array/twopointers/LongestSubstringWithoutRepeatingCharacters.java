package ru.edu.vtisov.array.twopointers;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char current = s.charAt(j);
            if (set.contains(current)) {
                do {
                    set.remove(s.charAt(i));
                } while (s.charAt(i++) != current);
            } else {
                j++;
                set.add(current);
                max = Math.max(set.size(), max);
            }
        }
        return max;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int max = 0;
//        int n = s.length();
//        int[] alphabet = new int[128];
//        for (int i = 0, j = 0; j < n; j++) {
//            char c = s.charAt(j);
//            i = Math.max(i, alphabet[c]);
//            max = Math.max(max, j - i + 1);
//            alphabet[c] = j + 1;
//        }
//        return max;
//    }

}