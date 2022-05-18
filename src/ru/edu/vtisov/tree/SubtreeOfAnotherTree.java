package ru.edu.vtisov.tree;

import ru.edu.vtisov.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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