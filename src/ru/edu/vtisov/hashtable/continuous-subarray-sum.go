package hashtable

// https://leetcode.com/problems/continuous-subarray-sum/

func checkSubarraySum(nums []int, k int) bool {
	modSeen := make(map[int]int)
	modPrefix := 0
	modSeen[0] = -1
	for i := range nums {
		modPrefix = (modPrefix + nums[i]) % k
		if seen, ok := modSeen[modPrefix]; ok {
			if i-seen > 1 {
				return true
			}
		} else {
			modSeen[modPrefix] = i
		}
	}
	return false
}
