package ru.edu.vtisov;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
        return node;
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