package ru.edu.vtisov.tree.dfs;

// https://leetcode.com/problems/flood-fill/

public class FloodFill {
    public int[][] floodFill(int[][] image, int i, int j, int newColor) {
        int color = image[i][j];
        if (color != newColor) dfs(image, i, j, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int i, int j, int color, int newColor) {
        if (image[i][j] == color) {
            image[i][j] = newColor;
            if (i >= 1) dfs(image, i - 1, j, color, newColor);
            if (j >= 1) dfs(image, i,  j- 1, color, newColor);
            if (i + 1 < image.length) dfs(image, i + 1, j, color, newColor);
            if (j + 1 < image[0].length) dfs(image, i, j + 1, color, newColor);
        }
    }
}