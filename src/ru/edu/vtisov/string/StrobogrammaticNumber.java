package ru.edu.vtisov.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/strobogrammatic-number

public class StrobogrammaticNumber {
    
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('6', '9');
        dict.put('8', '8');
        dict.put('9', '6');
        StringBuilder rotated = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (!dict.containsKey(c)) return false;
            rotated.append(dict.get(c));
        }
        String rotatedResult = rotated.toString();
        return num.equals(rotatedResult);
    }
}