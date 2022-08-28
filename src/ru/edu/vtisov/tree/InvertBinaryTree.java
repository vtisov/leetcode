package ru.edu.vtisov.tree;

// https://leetcode.com/problems/invert-binary-tree/

import ru.edu.vtisov.util.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}