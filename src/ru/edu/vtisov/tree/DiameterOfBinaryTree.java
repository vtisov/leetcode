package ru.edu.vtisov.tree;

// https://leetcode.com/problems/diameter-of-binary-tree/

import ru.edu.vtisov.util.TreeNode;

public class DiameterOfBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return 0;
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}