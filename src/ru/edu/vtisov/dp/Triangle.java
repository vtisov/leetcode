package ru.edu.vtisov.dp;

import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            List<Integer> previous = triangle.get(i - 1);
            int n = current.size();
            current.set(0, current.get(0) + previous.get(0));
            current.set(n - 1, current.get(n - 1) + previous.get(n - 2));
            for(int j = 1; j < n - 1; j++) {
                current.set(j, current.get(j) + Math.min(previous.get(j - 1), previous.get(j)));
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}