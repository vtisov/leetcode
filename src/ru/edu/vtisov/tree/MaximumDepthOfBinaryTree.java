package ru.edu.vtisov.tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}

// public class MaximumDepthOfBinaryTree {
//     public int maxDepth(TreeNode node) {
//         if (node == null) return 0;
//         int count = 0;
//         LinkedList<TreeNode> queue = new LinkedList<>();
//         queue.add(node);
//         while(!queue.isEmpty()) {
//             LinkedList<TreeNode> temp = new LinkedList<>();
//             while(!queue.isEmpty()) {
//                 TreeNode current = queue.remove();
//                 if (current.left != null) temp.add(current.left);
//                 if (current.right != null) temp.add(current.right);
//             }
//             queue = temp;
//             count++;
//         }
//         return count;
//     }
// }