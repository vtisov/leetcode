package ru.edu.vtisov.array;

// https://leetcode.com/problems/car-pooling

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int numberOfStops = 0;
        for (int[] trip : trips) {
            numberOfStops = Math.max(numberOfStops, trip[2]);
        }
        int[] stops = new int[numberOfStops + 1];
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        for (int x : stops) {
            capacity -= x;
            if (capacity < 0) return false;
        }
        return true;
    }

}