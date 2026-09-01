/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 /*
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
    result := []*TreeNode{}
    dict := make(map[string]int)

    var dfs func(node *TreeNode) string
    dfs = func(root *TreeNode) string {
        if root == nil {
            return ""
        }
        concat := "(" + dfs(root.Left) + ")" + strconv.Itoa(root.Val) + "(" + dfs(root.Right) + ")"
        dict[concat] += 1
        count := dict[concat]
        if count == 2 {
            result = append(result, root)
        }
        return concat
    }

    dfs(root)
    return result
}
*/

func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
    result := []*TreeNode{}
    cnt := make(map[int]int)
    tripletToId := make(map[string]int)

    var dfs func(node *TreeNode) int
    dfs = func(root *TreeNode) int {
        if root == nil {
            return 0
        }
        concat := "(" + strconv.Itoa(dfs(root.Left)) + ")" + strconv.Itoa(root.Val) + "(" + strconv.Itoa(dfs(root.Right)) + ")"
        id, exist := tripletToId[concat]
        if !exist {
            id = len(tripletToId) + 1
            tripletToId[concat] = id
        }
        cnt[id] += 1
        count := cnt[id]
        if count == 2 {
            result = append(result, root)
        }
        return id
    }

    dfs(root)
    return result
}
