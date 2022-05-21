package ru.edu.vtisov.tree;

// https://leetcode.com/problems/same-tree/

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(p);
//        queue.add(q);
//        while(!queue.isEmpty()) {
//            TreeNode node1 = queue.remove();
//            TreeNode node2 = queue.remove();
//            if (node1 == null && node2 == null) continue;
//            if (node1 == null || node2 == null) return false;
//            if (node1.val != node2.val) return false;
//            queue.add(node1.left);
//            queue.add(node2.left);
//            queue.add(node1.right);
//            queue.add(node2.right);
//        }
//        return true;
//    }
}