package ru.edu.vtisov.array.twopointers;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring

public class MinimumWindowSubstring {

    public String minWindow(String str, String desired) {
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < desired.length(); i++) {
            dict.merge(desired.charAt(i), 1, Integer::sum);
        }

        int left = 0;
        int right = 0;
        int formed = 0;
        int resultLeft = 0;
        int resultRight = 0;
        int resultLength = -1;

        while (right < str.length()) {
            char cur = str.charAt(right);
            window.merge(cur, 1, Integer::sum);

            if (dict.containsKey(cur) && window.get(cur).intValue() == dict.get(cur).intValue()) {
                formed++;
            }

            while(left <= right && formed == dict.size()) {

                if (resultLength == -1 || right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    resultLeft = left;
                    resultRight = right;
                }

                cur = str.charAt(left);
                window.merge(cur, -1, Integer::sum);

                if (dict.containsKey(cur) && window.get(cur) < dict.get(cur)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return resultLength == -1 ? "" : str.substring(resultLeft, resultRight + 1);
    }
}