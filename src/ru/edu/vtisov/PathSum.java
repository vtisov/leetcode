package ru.edu.vtisov;

import java.util.LinkedList;

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
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> sums = new LinkedList<>();
        nodes.add(root);
        sums.add(targetSum);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            int current = sums.removeFirst() - node.val;
            if (node.left == null && node.right == null && current == 0)
                return true;
            if (node.left != null) {
                nodes.addLast(node.left);
                sums.addLast(current);
            }
            if (node.right != null) {
                nodes.addLast(node.right);
                sums.addLast(current);
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean hasPathSum(TreeNode node, int targetSum) {
//         if (node == null) return false;
//         int sum = targetSum - node.val;
//         if (node.left == null && node.right == null)
//             return sum == 0;
//         return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
//     }
// }