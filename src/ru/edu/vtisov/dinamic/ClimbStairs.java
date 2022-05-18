package ru.edu.vtisov.dinamic;

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int dp1 = 1;
        int dp2 = 2;
        for (int i = 2; i < n; i++) {
            int temp = dp2;
            dp2 += dp1;
            dp1 = temp;
        }
        return dp2;
    }
}
