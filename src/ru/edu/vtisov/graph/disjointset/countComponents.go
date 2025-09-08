// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

type DisjointSet struct {
    root []int
    rank []int
    count int
}

func (d *DisjointSet) find(x int) int {
    if x != d.root[x] {
        d.root[x] = d.find(d.root[x])
    }
    return d.root[x]
}

func (d *DisjointSet) union(x int, y int) {
    xParent := d.find(x)
    yParent := d.find(y)
    if xParent != yParent {
        if d.rank[xParent] < d.rank[yParent] {
            d.root[xParent] = yParent
        } else if d.rank[yParent] < d.rank[xParent] {
            d.root[yParent] = xParent
        } else {
            d.root[yParent] = xParent
            d.rank[xParent]++
        }
        d.count--
    }
}

func newDisjointSet(n int) DisjointSet {
    set := DisjointSet{
        root: make([]int, n),
        rank: make([]int, n),
        count: n,
    }
    for i := range n {
        set.root[i] = i
        set.rank[i] = 0
    }
    return set
}

func countComponents(n int, edges [][]int) int {
    set := newDisjointSet(n)

    for _, e := range edges {
        set.union(e[0], e[1])
    }

    return set.count
}
