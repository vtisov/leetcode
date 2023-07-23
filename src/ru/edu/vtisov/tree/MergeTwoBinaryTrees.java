package ru.edu.vtisov.tree;

// https://leetcode.com/problems/merge-two-binary-trees/

import ru.edu.vtisov.util.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        node1.val += node2.val;
        node1.left = mergeTrees(node1.left, node2.left);
        node1.right = mergeTrees(node1.right, node2.right);
        return node1;
    }
}