// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            result.add(current);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                queue.addAll(node.children);
                current.add(node.val);
            }
        }
        return result;
    }
}
