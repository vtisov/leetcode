package ru.edu.vtisov.matrix;

// https://leetcode.com/problems/find-smallest-common-element-in-all-rows

public class FindSmallestCommonElementInAllRows {

    public int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int currentMax = 0;
        int[] pos = new int[mat.length];        
        while (true) {
            for (int i = 0; i < mat.length; i++) {
                while(pos[i] < m && mat[i][pos[i]] < currentMax) {
                    pos[i]++;
                }
                if (pos[i] >= m) {
                    return -1;   
                }
                if (mat[i][pos[i]] > currentMax) {
                    count = 0;
                    currentMax = mat[i][pos[i]];  
                }
                count++;
                if(count == mat.length) {
                    return currentMax;   
                }
            }    
        }
    }
}