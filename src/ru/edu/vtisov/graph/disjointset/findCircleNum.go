package disjointset

// https://leetcode.com/problems/number-of-provinces/

type UnionFind struct {
	root  []int
	rank  []int
	count int
}

func (u *UnionFind) find(n int) int {
	if u.root[n] != n {
		u.root[n] = u.find(u.root[n])
	}
	return u.root[n]
}

func (u *UnionFind) union(x int, y int) {
	xParent := u.find(x)
	yParent := u.find(y)
	if xParent != yParent {
		if u.rank[xParent] < u.rank[yParent] {
			u.root[xParent] = yParent
		} else if u.rank[yParent] < u.rank[xParent] {
			u.root[yParent] = xParent
		} else {
			u.root[yParent] = xParent
			u.rank[xParent] += 1
		}
		u.count--
	}

}

func NewUnionFind(n int) *UnionFind {
	u := &UnionFind{
		root:  make([]int, n),
		rank:  make([]int, n),
		count: n,
	}
	for i := 0; i < n; i++ {
		u.root[i] = i
		u.rank[i] = 1
	}
	return u
}

func findCircleNum(isConnected [][]int) int {
	u := NewUnionFind(len(isConnected))

	for i := range isConnected {
		for j := i + 1; j < len(isConnected[i]); j++ { // optimisation: symmetric matrix
			if isConnected[i][j] == 1 {
				u.union(i, j)
			}
		}
	}
	return u.count
}
