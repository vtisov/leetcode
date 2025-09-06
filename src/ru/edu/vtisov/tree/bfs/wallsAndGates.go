// https://leetcode.com/problems/walls-and-gates

var pos = [][2]int{
    {-1, 0},
    {0, -1},
    {0, 1},
    {1, 0},
}

func wallsAndGates(rooms [][]int)  {
    queue := make([][2]int, 0)
    for i := range rooms {
        for j := range rooms[i] {
            if rooms[i][j] == 0 {
                queue = append(queue, [2]int{i, j})
            }
        }
    }

    for len(queue) > 0 {
        for len(queue) > 0 {
            cur := queue[0]
            queue = queue[1:]

            for _, p := range pos {
                i := cur[0] + p[0]
                j := cur[1] + p[1]

                if i < 0 || j < 0 || i >= len(rooms) || j >= len(rooms[0]) {
                    continue
                }

                if rooms[i][j] == 2147483647 {
                    rooms[i][j] = rooms[cur[0]][cur[1]] + 1
                    queue = append(queue, [2]int{i, j})
                }
            }
        }
    }
}
