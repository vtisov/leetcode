package ru.edu.vtisov.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/maximum-number-of-ones

public class MaximumNumberOfOnes {
    
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        List<Integer> count = new ArrayList<>();
        for (int r = 0; r < sideLength; r++) {
            for (int c = 0; c < sideLength; c++) {
                count.add((1 + (width - 1 - c) / sideLength) * (1 + (height - 1 - r) / sideLength));
            }
        }

        count.sort(Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < maxOnes; i++) {
            answer += count.get(i);
        }
        return answer;
    }
    
//     public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
//         int answer = maxOnes * ((height / sideLength) * (width / sideLength));
//         int rest = maxOnes;
//
//         int use1 = Math.min((height % sideLength) * (width % sideLength), rest);
//         answer += ((height / sideLength) + (width / sideLength) + 1) * use1;
//         rest -= use1;
//
//         if (height / sideLength > width / sideLength) {
//             answer = calculate(width, height, sideLength, answer, rest, width % sideLength, height / sideLength, height % sideLength);
//         } else {
//             answer = calculate(height, height, sideLength, answer, rest, width % sideLength, width / sideLength, width % sideLength);
//         }
//         return answer;
//     }
//
//    private int calculate(int width, int height, int sideLength, int answer, int rest, int i, int i2, int i3) {
//        int use2 = Math.min(((width % sideLength) * sideLength) - ((height % sideLength) * (i)), rest);
//        answer += (i2) * use2;
//        rest -= use2;
//        int use3 = Math.min(((i3) * sideLength) - ((height % sideLength) * (i)), rest);
//        answer += (width / sideLength) * use3;
//        return answer;
//    }
}