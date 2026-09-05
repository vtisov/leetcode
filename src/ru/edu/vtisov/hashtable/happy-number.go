package hashtable

// https://leetcode.com/problems/happy-number

/*
func isHappy(n int) bool {
	seen := make(map[int]bool)
	for n != 1 && !seen[n] {
		seen[n] = true
		n = next(n)
	}
	return n == 1
}
*/

func isHappy(n int) bool {
	slow := n
	fast := next(n)
	for fast != 1 && slow != fast {
		slow = next(slow)
		fast = next(next(fast))
	}
	return fast == 1
}

func next(n int) int {
	result := 0
	for n > 0 {
		d := n % 10
		n = n / 10
		result += d * d
	}
	return result
}
