package binarysearch

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

func findMin(nums []int) int {
	i, j := 0, len(nums)-1
	for i < j {
		mid := i + (j-i)/2
		if nums[mid] > nums[j] {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return nums[i]
}
