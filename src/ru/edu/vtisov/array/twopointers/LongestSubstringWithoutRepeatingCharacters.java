package ru.edu.vtisov.array.twopointers;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        int[] alphabet = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            i = Math.max(i, alphabet[c]);
            max = Math.max(max, j - i + 1);
            alphabet[c] = j + 1;
        }
        return max;
    }

}