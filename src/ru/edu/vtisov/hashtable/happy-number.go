package hashtable

func isHappy(n int) bool {
	seen := make(map[int]bool)
	for n != 1 && !seen[n] {
		seen[n] = true
		n = next(n)
	}
	return n == 1
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
