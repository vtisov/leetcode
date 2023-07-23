package ru.edu.vtisov.dp;

// https://leetcode.com/problems/delete-operation-for-two-strings

public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int[] previous = new int[word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            int[] current = new int[word2.length() + 1];
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    current[j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    current[j] = previous[j - 1];
                } else {
                    current[j] = 1 + Math.min(previous[j], current[j - 1]);
                }
            }
            previous = current;
        }
        return previous[word2.length()];
    }
}