package ru.edu.vtisov.matrix;

// TODO
public class RotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // public void rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     for (int i = 0; i < (n + 1) / 2; i ++) {
    //         for (int j = 0; j < n / 2; j++) {
    //             int temp = matrix[n - 1 - j][i];
    //             matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
    //             matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
    //             matrix[j][n - 1 - i] = matrix[i][j];
    //             matrix[i][j] = temp;
    //         }
    //     }
    // }
}
