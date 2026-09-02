package twopointers

func maxArea(height []int) int {
	result := 0
	i := 0
	j := len(height) - 1
	for i < j {
		result = max(result, (j-i)*min(height[i], height[j]))
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return result
}
