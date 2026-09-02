package hashtable

import "slices"

func findAnagrams(s string, p string) []int {
	pattern := make([]int, 26)
	current := make([]int, 26)
	result := []int{}

	for _, c := range p {
		pattern[c-'a']++
	}

	for i := 0; i < len(s); i++ {
		current[s[i]-'a']++

		if i < len(p)-1 {
			continue
		}

		if slices.Equal(pattern, current) {
			result = append(result, i-len(p)+1)
		}

		current[s[i-len(p)+1]-'a']--
	}

	return result
}
