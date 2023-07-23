package ru.edu.vtisov.dp;

// https://leetcode.com/problems/integer-break

/**
Observation:

If you dive a little deep, you will find that the major factor which is playing a role in the result is 3.

So, our target is to express n in the maximum no.of 3's and the remaining as 2's.
*/
public class IntegerBreak {
    
    // dp solution
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int max = 1;
            // for (int j = 1; 2 * j <= i; j++) {
            for (int j = 1; j <= i; j++) {
                int factor1 = Math.max(j, dp[j]);
                int factor2 = Math.max(i - j, dp[i - j]);
                max = Math.max(max, factor1 * factor2);
            }
            dp[i] = max;
        }
        return dp[n];
    }
    
    /** math solution
    public int integerBreak(int n) {
        if (n < 4) {
            return (n == 2) ? 1 : 2;
        }
        
        // q denotes the maximum number of 3
        int q = n / 3;
        int rest = n % 3;
        
        // if the rest could be odd, we need to adjust it until even.
        while(rest % 2 == 1) {
            q--;
            rest += 3;
        }
        return (int)(Math.pow(3, q) * Math.pow(2, rest / 2));
    }
    */
}