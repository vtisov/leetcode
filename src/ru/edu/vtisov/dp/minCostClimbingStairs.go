// https://leetcode.com/problems/min-cost-climbing-stairs/

func minCostClimbingStairs(cost []int) int {
    if len(cost) == 1 {
        return cost[0]
    }
    n := len(cost)
    memo := make([]int, n)
    memo[0] = cost[0]
    memo[1] = cost[1]
    for i := 2; i < n; i++ {
        memo[i] = min(memo[i - 1], memo[i - 2]) + cost[i]
    }
    return min(memo[n - 1], memo[n - 2])
}
