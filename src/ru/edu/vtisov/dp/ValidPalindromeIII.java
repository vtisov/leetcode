package ru.edu.vtisov.dp;

// https://leetcode.com/problems/valid-palindrome-iii

public class ValidPalindromeIII {

    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1] <= k;
    }

//     better solution with O(n) memory
//    public boolean isValidPalindrome(String s, int k) {
//        int[] dp = new int[s.length()];
//        int temp = 0;
//        int previous = 0;
//        for (int i = s.length() - 2; i >= 0; i--) {
//            previous = 0;
//            for (int j = i + 1; j < s.length(); j++) {
//                temp = dp[j];
//                if (s.charAt(i) == s.charAt(j)) dp[j] = previous;
//                else dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
//                previous = temp;
//            }
//        }
//        return dp[s.length() - 1] <= k;
//    }
}