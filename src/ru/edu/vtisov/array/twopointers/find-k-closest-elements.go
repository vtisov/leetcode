// https://leetcode.com/problems/find-k-closest-elements/

func findClosestElements(arr []int, k int, x int) []int {
    result := []int{}

    left := 0
    right := len(arr) - k

    for left < right {
        mid := left + (right-left)/2
        if x - arr[mid] > arr[mid + k] - x {
            left = mid + 1
        } else {
            right = mid
        }
    }

    for i := left; i < left + k; i++ {
        result = append(result, arr[i])
    } 

    return result
}

   
