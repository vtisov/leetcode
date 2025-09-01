func validWordAbbreviation(word string, abbr string) bool {
    i, j := 0, 0
    for i < len(word) && j < len(abbr) {
        if word[i] == abbr[j] {
            i++
            j++
            continue
        }
        if !unicode.IsDigit(rune(abbr[j])) || abbr[j] == '0' {
            return false
        }
        skip := 0
        for j < len(abbr) && unicode.IsDigit(rune(abbr[j])) {
            skip = skip*10 + int(abbr[j] - '0')
            j++
        }
        i += skip
    }

    return i == len(word) && j == len(abbr)
}
