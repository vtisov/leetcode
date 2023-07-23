package ru.edu.vtisov.tree;

import ru.edu.vtisov.util.TreeNode;

import java.util.LinkedList;

// https://leetcode.com/problems/path-sum/

public class PathSum {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;
        int sum = targetSum - node.val;
        if (node.left == null && node.right == null)
            return sum == 0;
        return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
    }
}