package ru.edu.vtisov.dp;

// https://leetcode.com/problems/edit-distance

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // if one of the strings is empty
        if (n * m == 0)
            return n + m;
        
        int[][] dp = new int[n + 1][m + 1];
            
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int leftTop = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) leftTop += 1;
                dp[i][j] = Math.min(left, Math.min(top, leftTop));
            }
        }
        return dp[n][m];
    }
}