// https://leetcode.com/problems/maximal-square

func maximalSquare(matrix [][]byte) int {
	n := len(matrix)
	m := len(matrix[0])
	result := 0
	prev := make([]int, m+1)
	cur := make([]int, m+1)

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if matrix[i-1][j-1] == '1' {
				cur[j] = min(prev[j], prev[j-1], cur[j-1]) + 1
				result = max(result, cur[j])
			}
		}
		prev, cur = cur, prev

		for j := 0; j <= m; j++ {
			cur[j] = 0
		}
	}

	return result * result
}

/*
func maximalSquare(matrix [][]byte) int {
	n := len(matrix)
	m := len(matrix[0])
	result := 0
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if matrix[i-1][j-1] == '1' {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
				result = max(result, dp[i][j])
			}
		}
	}

	return result * result
}
*/
