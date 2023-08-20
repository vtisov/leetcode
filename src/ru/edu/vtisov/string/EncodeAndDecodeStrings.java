package ru.edu.vtisov.string;

// https://leetcode.com/problems/encode-and-decode-strings

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    private static final String DELIMETER = "/:";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str: strs) {
            encoded.append(str.length() + DELIMETER + str);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delimeter = s.indexOf(DELIMETER, i);
            int length = Integer.parseInt(s.substring(i, delimeter));
            decoded.add(s.substring(delimeter + 2, delimeter + 2 + length));
            i = delimeter + 2 + length;
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));