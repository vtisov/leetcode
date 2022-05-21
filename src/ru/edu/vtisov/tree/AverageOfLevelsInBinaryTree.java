package ru.edu.vtisov.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            double sum = 0;
            double count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode current = queue.remove();
                sum += current.val;
                count++;
                if (current.left != null) {
                    temp.add(current.left);
                }
                if (current.right != null) {
                    temp.add(current.right);
                }
            }
            queue = temp;
            result.add(sum / count);
        }
        return result;
    }
}