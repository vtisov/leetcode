package binarysearch

func searchRange(nums []int, target int) []int {
	left := binarySearch(nums, target, true)
	right := binarySearch(nums, target, false)
	return []int{left, right}
}

func binarySearch(nums []int, target int, isLeft bool) int {
	i, j := 0, len(nums)-1
	for i <= j {
		mid := i + ((j - i) / 2)
		if nums[mid] == target {
			if isLeft {
				if (mid == 0) || nums[mid-1] != target {
					return mid
				}
				j = mid - 1
			} else {
				if (mid == len(nums)-1) || nums[mid+1] != target {
					return mid
				}
				i = mid + 1
			}
		} else if nums[mid] < target {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}
	return -1
}
