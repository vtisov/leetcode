package ru.edu.vtisov.tree.bfs;

import ru.edu.vtisov.util.Node;

import java.util.LinkedList;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Node> temp = new LinkedList<>();
            Node stub = new Node();
            Node previous = stub;
            while(!queue.isEmpty()) {
                Node current = queue.removeFirst();
                if (current == null) continue;
                temp.add(current.left);
                temp.add(current.right);
                previous.next = current;
                previous = current;
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
