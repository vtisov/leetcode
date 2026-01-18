// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

func maximumScore(nums []int, multipliers []int) int {
    n := len(nums)
    m := len(multipliers)
    cur := make([]int, m + 1)
    prev := make([]int, m + 1)
    
    for i := m - 1; i >= 0; i-- {
        multi := multipliers[i]
        for left := i; left >= 0; left-- {
            right := n - 1 - (i - left)
            cur[left] = max(
                multi * nums[left] + prev[left + 1],
                multi * nums[right] + prev[left])
        }
        prev, cur = cur, prev
    }
    return prev[0]
}

/*
func maximumScore(nums []int, multipliers []int) int {
    n := len(nums)
    m := len(multipliers)
    dp := make([][]int, m + 1)
    for i := range dp {
        dp[i] = make([]int, i + 1)
    }

    for i := m - 1; i >= 0; i-- {
        multi := multipliers[i]
        for left := i; left >= 0; left-- {
            right := n - 1 - (i - left)
            dp[i][left] = max(
                multi * nums[left] + dp[i + 1][left + 1],
                multi * nums[right] + dp[i + 1][left])
        }
    }
    return dp[0][0]
}
*/

/*
func dp(nums []int, multipliers []int, memo [][]int, i int, left int) int {
    if i == len(multipliers) {
        return 0
    }

    right := len(nums) - 1 - (i - left)
    mult := multipliers[i]
    if memo[i][left] == 0 {
        memo[i][left] = max(
            mult * nums[left] + dp(nums, multipliers, memo, i + 1, left + 1),
            mult * nums[right] + dp(nums, multipliers, memo, i + 1, left))
    }
    return memo[i][left]
}

func maximumScore(nums []int, multipliers []int) int {
    memo := make([][]int, len(multipliers));
    for i := range memo {
        memo[i] = make([]int, i + 1)
    }
    return dp(nums, multipliers, memo, 0, 0)
}
*/
