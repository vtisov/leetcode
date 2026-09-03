package binarysearch

func search(nums []int, target int) int {
	rotate := findRotate(nums)
	left := binarySearch(nums, target, 0, rotate-1)
	right := binarySearch(nums, target, rotate, len(nums)-1)
	return max(left, right)
}

func findRotate(nums []int) int {
	i, j := 0, len(nums)-1
	for i < j {
		mid := i + (j-i)/2
		if nums[mid] > nums[j] {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return i
}

func binarySearch(nums []int, target int, i int, j int) int {
	for i <= j {
		mid := i + (j-i)/2
		if nums[mid] == target {
			return mid
		} else if target < nums[mid] {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return -1
}
