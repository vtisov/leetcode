package ru.edu.vtisov.tree;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        return Math.min(left, right) + 1;
    }

//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        int count = 0;
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            count++;
//            Queue<TreeNode> temp = new LinkedList<>();
//            while(!queue.isEmpty()) {
//                TreeNode node = queue.remove();
//                if (node.left == null && node.right == null)
//                    return count;
//                if (node.left != null)
//                    temp.add(node.left);
//                if (node.right != null)
//                    temp.add(node.right);
//            }
//            queue = temp;
//        }
//        return count;
//    }
}