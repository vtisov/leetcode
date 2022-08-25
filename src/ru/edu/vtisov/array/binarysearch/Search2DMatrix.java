package ru.edu.vtisov.array.binarysearch;

public class Search2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n * m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = matrix[mid / m][mid % m];
            if (value == target) return true;
            if (value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}