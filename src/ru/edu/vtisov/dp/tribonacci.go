// https://leetcode.com/problems/n-th-tribonacci-number

func tribonacci(n int) int {
    if n == 0 {
        return 0
    }
    if n == 1 || n == 2 {
        return 1
    }
    memo1 := 0
    memo2 := 1
    memo3 := 1
    for i := 3; i <= n; i++ {
        temp := memo1 + memo2 + memo3
        memo1 = memo2
        memo2 = memo3
        memo3 = temp
    }
    return memo3
}

/*
func tribonacci(n int) int {
    if n == 0 {
        return 0
    }
    if n == 1 || n == 2 {
        return 1
    }
    memo := make([]int, n + 1)
    memo[0] = 0
    memo[1] = 1
    memo[2] = 1
    for i := 3; i <= n; i++ {
        memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3] 
    }
    return memo[n]
}
*/
