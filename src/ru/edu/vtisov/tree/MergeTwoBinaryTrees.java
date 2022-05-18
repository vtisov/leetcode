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

// class Solution {
//     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//         if (root1 == null) return root2;
//         LinkedList<TreeNode> queue = new LinkedList<>();
//         LinkedList<TreeNode> temps = new LinkedList<>();
//         queue.add(root1);
//         queue.add(root2);
//         TreeNode result = new TreeNode();
//         temps.add(result);
//         while (!queue.isEmpty()) {
//             TreeNode node1 = queue.remove();
//             TreeNode node2 = queue.remove();
//             TreeNode current = temps.remove();
//             if (node1 == null && node2 == null) continue;
//             int val1 = node1 == null ? 0 : node1.val;
//             int val2 = node2 == null ? 0 : node2.val;
//             current.val = val1 + val2;

//             if ((node1 != null && node1.left != null) || (node2 != null && node2.left != null)) {
//                 current.left = new TreeNode();
//                 queue.add(node1 == null ? null : node1.left);
//                 queue.add(node2 == null ? null : node2.left);
//                 temps.add(current.left);
//             }

//             if ((node1 != null && node1.right != null) || (node2 != null && node2.right != null) ) {
//                 current.right = new TreeNode();
//                 queue.add(node1 == null ? null : node1.right);
//                 queue.add(node2 == null ? null : node2.right);
//                 temps.add(current.right);
//             }
//         }
//         return result;
//     }
// }