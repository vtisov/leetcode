package ru.edu.vtisov.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/

public class LetterCasePermutation {

    private final List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        letterCasePermutation("", s, 0);
        return result;
    }

    private void letterCasePermutation(String current, String s, int pos) {
        if (current.length() == s.length()) {
            result.add(current);
            return;
        }
        char c = s.charAt(pos);
        if ('a' <= c && c <= 'z') {
            letterCasePermutation(current + Character.toUpperCase(c), s, pos + 1);
        }
        if ('A' <= c && c <= 'Z') {
            letterCasePermutation(current + Character.toLowerCase(c), s, pos + 1);
        }
        letterCasePermutation(current + s.charAt(pos), s, pos + 1);
    }
}