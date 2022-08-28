package ru.edu.vtisov.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {
    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", n, 0);
        return result;
    }

    private void backtrack(String current, int toOpen, int toClose) {
        if (toOpen == 0 && toClose == 0) result.add(current);
        if (toOpen > 0) backtrack(current + "(", toOpen - 1, toClose + 1);
        if (toClose > 0) backtrack(current + ")", toOpen, toClose - 1);
    }
}