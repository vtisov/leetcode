package ru.edu.vtisov.dp;

// https://leetcode.com/problems/minimum-costs-using-the-train-line

public class MinimumCostsUsingTheTrainLine {

    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] result = new long[regular.length];
        long prevRegular = 0;
        long prevExpress = expressCost;

        for (int i = 1; i <= regular.length; i++) {
            long currentRegular = regular[i - 1] + Math.min(prevRegular, prevExpress);
            long currentExpress = express[i - 1] + Math.min(expressCost + prevRegular, prevExpress);

            result[i - 1] = Math.min(currentRegular, currentExpress);

            prevRegular = currentRegular;
            prevExpress = currentExpress;

        }
        return result;
    }

    // public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
    //     long[] result = new long[regular.length];
    //     long[] dpRegular = new long[regular.length + 1];
    //     long[] dpExpress = new long[express.length + 1];
    //     dpRegular[0] = 0;
    //     dpExpress[0] = expressCost;

    //     for (int i = 1; i < dpRegular.length; i++) {
    //         dpRegular[i] = regular[i - 1] + Math.min(dpRegular[i - 1], dpExpress[i - 1]);
    //         dpExpress[i] = express[i - 1] + Math.min(expressCost + dpRegular[i - 1], dpExpress[i - 1]);
    //         result[i - 1] = Math.min(dpRegular[i], dpExpress[i]);
    //     }
    //     return result;
    // }
}