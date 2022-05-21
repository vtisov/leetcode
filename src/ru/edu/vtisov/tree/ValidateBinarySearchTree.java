package ru.edu.vtisov.tree;

// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}