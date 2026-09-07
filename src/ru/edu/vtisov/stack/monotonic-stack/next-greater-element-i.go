package monotonic_stack

// https://leetcode.com/problems/next-greater-element-i

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	stack := make([]int, 0)
	dict := make(map[int]int)
	result := make([]int, len(nums1))

	for _, n := range nums2 {
		for len(stack) > 0 && stack[len(stack)-1] < n {
			dict[stack[len(stack)-1]] = n
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, n)
	}

	for _, n := range stack {
		dict[n] = -1
	}

	for i, n := range nums1 {
		next := dict[n]
		result[i] = next
	}

	return result
}
