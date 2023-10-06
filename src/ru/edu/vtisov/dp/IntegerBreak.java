package ru.edu.vtisov.dp;

// https://leetcode.com/problems/integer-break

/**
Observation:

If you dive a little deep, you will find that the major factor which is playing a role in the result is 3.

So, our target is to express n in the maximum no.of 3's and the remaining as 2's.
*/
public class IntegerBreak {

    // dp solution
    int[] memory;

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        memory = new int[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        if (n <= 3) {
            return n;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        int answer = n;

        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, i * dp(n - i));
        }
        memory[n] = answer;
        return answer;
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