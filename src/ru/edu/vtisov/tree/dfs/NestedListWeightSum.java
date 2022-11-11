package ru.edu.vtisov.tree.dfs;

// https://leetcode.com/problems/nested-list-weight-sum

import java.util.List;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    
    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * depth;
            } else {
                sum += dfs(nested.getList(), depth + 1);
            }
        }
        return sum;
    }
    
//     public int depthSum(List<NestedInteger> nestedList) {
//         Queue<NestedInteger> queue = new LinkedList<>();
//         queue.addAll(nestedList);
//         int depth = 1;
//         int total = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 NestedInteger nested = queue.poll();
//                 if (nested.isInteger()) {
//                     total += nested.getInteger() * depth;
//                 } else {
//                     queue.addAll(nested.getList());
//                 }
//             }
//             depth++;
//         }
//         return total;
//     }
}