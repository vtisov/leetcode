// https://leetcode.com/problems/max-consecutive-ones-iii/

func longestOnes(nums []int, k int) int {
    i := 0
    j := 0
    result := 0
    cur := 0

    for ; j < len(nums); j++ {
        if nums[j] == 0 {
            cur++
        }
        for ; cur > k; i++ {
            if nums[i] == 0 {
                cur--
            }
        }
        result = max(result, j - i + 1)
    }
    return result
}
