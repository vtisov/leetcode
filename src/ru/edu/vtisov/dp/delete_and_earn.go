// https://leetcode.com/problems/delete-and-earn/

func deleteAndEarn(nums []int) int {
    
    gain := make(map[int]int);
    
    maxNum := 0
    for _, v := range nums {
        gain[v] += v
        maxNum = max(maxNum, v)
    }

    if maxNum == 0 {
        return 0
    }
    prev := 0
    cur := gain[1]

    for i := 2; i <= maxNum; i++ {
        temp := max(cur, prev + gain[i])
        prev = cur
        cur = temp
    }

    return cur
}

/*
func deleteAndEarn(nums []int) int {
    
    gain := make(map[int]int);
    
    maxNum := 0
    for _, v := range nums {
        gain[v] += v
        maxNum = max(maxNum, v)
    }

    dp := make([]int, maxNum + 1)
    dp[1] = gain[1]

    for i := 2; i <= maxNum; i++ {
        dp[i] = max(dp[i - 1], dp[i - 2] + gain[i])
    }

    return dp[maxNum]
}
*/

/*
func deleteAndEarn(nums []int) int {
    
    gain := make(map[int]int);
    dp := make(map[int]int);
    
    maxNum := 0
    for _, v := range nums {
        gain[v] += v
        maxNum = max(maxNum, v)
    }
    return maxPoints(maxNum, gain, dp)
}

func maxPoints(cur int, gain map[int]int, dp map[int]int) int {
    if cur == 0 {
        return 0
    }
    if cur == 1 {
        return gain[1]
    }
    v, ok := dp[cur]
    if ok {
        return v
    }

    dp[cur] = max(maxPoints(cur - 1, gain, dp), maxPoints(cur - 2, gain, dp) + gain[cur])
    return dp[cur]
}
*/
