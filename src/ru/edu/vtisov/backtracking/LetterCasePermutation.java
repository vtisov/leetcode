package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/

public class LetterCasePermutation {

    private final List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(), 0);
        return result;
    }

    private void backtrack(char[] chars, int current) {
        if (current == chars.length) {
            result.add(new String(chars));
            return;
        }
        backtrack(chars, current + 1);
        if (Character.isLowerCase(chars[current])) {
            chars[current] = Character.toUpperCase(chars[current]);
            backtrack(chars, current + 1);
            chars[current] = Character.toLowerCase(chars[current]);
        }
        if (Character.isUpperCase(chars[current])) {
            chars[current] = Character.toLowerCase(chars[current]);
            backtrack(chars, current + 1);
            chars[current] = Character.toUpperCase(chars[current]);
        }
    }
}