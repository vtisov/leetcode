package array

// https://leetcode.com/problems/encode-and-decode-strings

import "strings"

type Codec struct{}

func (Codec) Encode(strs []string) string {
	var buffer = strings.Builder{}
	for _, str := range strs {
		buffer.WriteString(strings.ReplaceAll(str, "/", "//"))
		buffer.WriteString("/:")
	}
	return buffer.String()
}

func (Codec) Decode(s string) []string {
	var result = []string{}
	var buffer = strings.Builder{}

	for i := 0; i < len(s); {
		if i+1 < len(s) && s[i] == '/' && s[i+1] == '/' {
			buffer.WriteByte('/')
			i += 2
		} else if i+1 < len(s) && s[i] == '/' && s[i+1] == ':' {
			result = append(result, buffer.String())
			buffer.Reset()
			i += 2
		} else {
			buffer.WriteByte(s[i])
			i++
		}
	}
	return result
}
