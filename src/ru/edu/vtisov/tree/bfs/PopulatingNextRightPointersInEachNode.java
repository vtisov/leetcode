package ru.edu.vtisov.tree.bfs;

import ru.edu.vtisov.util.Node;

import java.util.LinkedList;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Node> temp = new LinkedList<>();
            Node prev = null;
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (node.left == null) continue;
                temp.add(node.left);
                temp.add(node.right);
                if (prev != null) prev.next = node.left;
                node.left.next = node.right;
                prev = node.right;
            }
            queue = temp;
        }
        return root;
    }
}

// public class PopulatingNextRightPointersInEachNode {
//     public Node connect(Node root) {
//         if (root == null) {
//             return root;
//         }
//         if (root.next != null && root.right != null) {
//             root.right.next = root.next.left;
//         }
//         if (root.left != null) {
//             root.left.next = root.right;
//         }
//         connect(root.left);
//         connect(root.right);
//         return root;
//     }
// }