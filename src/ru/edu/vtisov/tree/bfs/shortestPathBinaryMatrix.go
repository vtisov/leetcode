// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

var pos = [][]int{
        []int{-1, -1},
        []int{-1, 0},
        []int{0, -1},
        []int{0, 1},
        []int{1, 0},
        []int{1, -1},
        []int{-1, 1},
        []int{1, 1},
    }

type Point struct {
    x, y, count int
}

func shortestPathBinaryMatrix(grid [][]int) int {
    n := len(grid)
    if grid[0][0] != 0 || grid[n - 1][n - 1] != 0 {
        return -1
    }

    queue := []Point{{ x: 0, y: 0, count: 1 }}

    for len(queue) > 0 {
        cur := queue[0]
        queue = queue[1:]

        if cur.x == n - 1 && cur.y == n - 1 {
            return cur.count
        }
        for _, p := range pos {
            i := cur.x + p[0]
            j := cur.y + p[1]
            if i >= 0 && j >= 0 && i < n && j < n && grid[i][j] != 1 {
                grid[i][j] = 1
                queue = append(queue, Point{x: i, y: j, count: cur.count + 1})
            }
        }
    }
    return -1
}
