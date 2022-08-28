package ru.edu.vtisov.tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree

import ru.edu.vtisov.util.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}