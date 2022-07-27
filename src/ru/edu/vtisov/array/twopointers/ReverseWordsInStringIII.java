package ru.edu.vtisov.array.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(str -> {
                    char[] chars = str.toCharArray();
                    reverseString(chars);
                    return new String(chars);
                })
                .collect(Collectors.joining(" "));
    }

    private void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}