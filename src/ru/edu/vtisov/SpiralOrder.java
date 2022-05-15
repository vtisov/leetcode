package ru.edu.vtisov;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int direction = 0;
        List<Integer> result = new ArrayList<>();

        while(top <= bottom && left <= right) {
            if(direction == 0) {
                for(int i = left; i < right + 1; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            } else if(direction == 1) {
                for(int i = top; i < bottom + 1; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            } else if(direction == 2) {
                for(int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            } else if(direction == 3) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }
}