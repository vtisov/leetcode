package ru.edu.vtisov.array;

import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                intervals[i - 1] = null;
                count++;
            }
        }
        int[][] result = new int[intervals.length - count][];
        for(int i = 0, j = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                result[j] = intervals[i];
                j++;
            }
        }
        return result;
    }
}

/* предлагаемое решение leetcode
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
*/