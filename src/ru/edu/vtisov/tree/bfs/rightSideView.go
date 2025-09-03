// https://leetcode.com/problems/binary-tree-right-side-view/

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }

    result := make([]int, 0)
    queue := []*TreeNode{root}
    
    for len(queue) > 0 {
        next := make([]*TreeNode, 0)
        result = append(result, queue[len(queue) - 1].Val)
        for _, el := range queue {
            if el.Left != nil {
                next = append(next, el.Left)
            }
            if el.Right != nil {
                next = append(next, el.Right)
            }
        }
        queue = next
    }
    return result
}
