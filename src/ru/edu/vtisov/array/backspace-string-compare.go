package array

// https://leetcode.com/problems/backspace-string-compare

func backspaceCompare(s string, t string) bool {
	i, j := len(s)-1, len(t)-1

	for i >= 0 || j >= 0 {

		i = next(s, i)
		j = next(t, j)

		if i >= 0 && j >= 0 && s[i] != t[j] {
			return false
		}
		if (i >= 0) != (j >= 0) { // остались символы в одной из строк
			return false
		}
		i--
		j--
	}
	return true
}

func next(s string, i int) int {
	skip := 0
	for i >= 0 {
		if s[i] == '#' {
			skip++
			i--
		} else if skip > 0 {
			skip--
			i--
		} else {
			break
		}
	}
	return i
}
