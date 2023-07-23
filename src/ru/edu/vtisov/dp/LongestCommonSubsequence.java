package ru.edu.vtisov.dp;

// https://leetcode.com/problems/longest-common-subsequence/submissions/

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {    
        int[] previous = new int[text2.length() + 1];
        for (int row = 1; row <= text1.length(); row++) {
            int[] current = new int[text2.length() + 1];   
            for (int col = 1; col <= text2.length(); col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                  current[col] = 1 + previous[col - 1];
                } else {
                  current[col] = Math.max(previous[col], current[col - 1]);
                }
            }
            previous = current;
        }
        return previous[previous.length - 1];
    }
}