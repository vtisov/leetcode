// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {

            int size = queue.size(); // save current size of queue       
            for (int i = 0; i < size; i++) {
                var current =  queue.poll();

                if (i < size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
}

// class Solution {
//     public Node connect(Node root) {
//         if (root == null) {
//             return root;
//         }

//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             var current = queue.poll();

//             if (current.left != null) {
//                 current.left.next = current.right;
//             }

//             if (current.next != null && current.right != null) {
//                 current.right.next = current.next.left;
//             }

//             if (current.left != null) {
//                 queue.offer(current.left);
//             }
            
//             if (current.right != null) {
//                 queue.offer(current.right);
//             }
//         }
//         return root;
//     }
// }

// class Solution {
//     public Node connect(Node root) {
//         if (root == null) {
//             return root;
//         }
        
//         if (root.left != null) {
//             root.left.next = root.right;
//         }

//         if (root.next != null && root.right != null) {
//             root.right.next = root.next.left;
//         }
        
//         connect(root.left);
//         connect(root.right);
//         return root;
//     }
// }
