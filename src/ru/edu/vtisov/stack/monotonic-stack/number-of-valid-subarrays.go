package monotonic_stack

// https://leetcode.com/problems/number-of-valid-subarrays/

func validSubarrays(nums []int) int {
	stack := make([]int, 0)
	result := 0

	for i, n := range nums {
		for len(stack) > 0 && nums[stack[len(stack)-1]] > n {
			result += i - stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}

	for _, n := range stack {
		result += len(nums) - n
	}
	return result
}
