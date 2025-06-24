package leetcode

import (
	"fmt"
	"strconv"
)

func MaximumSwap(num int) int {
	c := []rune(strconv.Itoa(num))
	n := len(c)
	maxRight := make([]int, n)
	maxRight[n-1] = n - 1
	fmt.Println(maxRight)
	for i := n - 2; i >= 0; i-- {
		if c[i] > c[maxRight[i+1]] {
			maxRight[i] = i
		} else {
			maxRight[i] = maxRight[i+1]
		}
	}
	for i := 0; i < n; i++ {
		if c[i] < c[maxRight[i]] {
			temp := c[i]
			c[i] = c[maxRight[i]]
			c[maxRight[i]] = temp
			atoi, _ := strconv.Atoi(string(c))
			return atoi
		}
	}
	return num
}
