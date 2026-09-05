package hashtable

// https://leetcode.com/problems/first-unique-character-in-a-string

func firstUniqChar(s string) int {
	count := make(map[int32]int)

	for _, c := range s {
		count[c]++
	}
	for i, c := range s {
		if count[c] == 1 {
			return i
		}
	}
	return -1
}
