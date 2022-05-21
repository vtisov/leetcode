package ru.edu.vtisov.tree;

// https://leetcode.com/problems/subtree-of-another-tree/

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode node, TreeNode subRoot) {
        if (node == null) return false;
        if (isSameTree(node, subRoot)) return true;
        return isSubtree(node.left, subRoot) || isSubtree(node.right, subRoot);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val) return false;
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}