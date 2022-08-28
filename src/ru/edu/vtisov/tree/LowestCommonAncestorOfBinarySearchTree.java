package ru.edu.vtisov.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import ru.edu.vtisov.util.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (node.val < p.val && node.val < q.val)
                node = node.right;
            else if (node.val > p.val && node.val > q.val)
                node = node.left;
            else
                return node;
        }
        return null;
    }
}

// public class LowestCommonAncestorOfBinarySearchTree {
//     public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
//         if (node.val < p.val && node.val < q.val)
//             return lowestCommonAncestor(node.right, p, q);
//         else if (node.val > p.val && node.val > q.val)
//             return lowestCommonAncestor(node.left, p, q);
//         return node;
//     }
// }