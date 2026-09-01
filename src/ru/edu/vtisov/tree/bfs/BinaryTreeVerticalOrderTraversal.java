// https://leetcode.com/problems/binary-tree-vertical-order-traversal/

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
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int min = 0;
        int max = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        queue.offer(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            if (node == null) {
                continue;
            }
            min = Math.min(min, column);
            max = Math.max(max, column);
            columns.putIfAbsent(column, new LinkedList<>());
            columns.get(column).add(node.val);
            queue.offer(new Pair<>(node.left, column - 1));
            queue.offer(new Pair<>(node.right, column + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(columns.get(i));
        }
        return result;
    }
}
