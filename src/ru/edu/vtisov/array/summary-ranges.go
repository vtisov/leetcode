// https://leetcode.com/problems/summary-ranges/

func summaryRanges(nums []int) []string {
    results := []string{}
    if len(nums) == 0 {
        return results
    }
    if len(nums) == 1 {
        results = append(results, strconv.Itoa(nums[0]))
        return results
    }
    min := nums[0]
    max := nums[0]
    for i := 1; i < len(nums); i++ {
        if nums[i] - max > 1 {
            if max == min {
                results = append(results, strconv.Itoa(min))
            } else {
                results = append(results, strconv.Itoa(min) + "->" + strconv.Itoa(max))
            }
            min = nums[i]
        }
        max = nums[i]
    }
    if max == min {
        results = append(results, strconv.Itoa(min))
    } else {
        results = append(results, strconv.Itoa(min) + "->" + strconv.Itoa(max))
    }
    return results
}
