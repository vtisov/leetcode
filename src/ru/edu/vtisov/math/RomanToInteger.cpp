package ru.edu.vtisov.math;

// https://leetcode.com/problems/roman-to-integer

class RomanToInteger {
public:
    int romanToInt(string s) {
        unordered_map<char, int> m;
        
        m['I'] = 1;
        m['V'] = 5;
        m['X'] = 10;
        m['L'] = 50;
        m['C'] = 100;
        m['D'] = 500;
        m['M'] = 1000;
        
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(m[s[i]] < m[s[i + 1]]) {
                result -= m[s[i]];
            } else {
                result += m[s[i]];
            }
        }
        return result;
    }

    // int romanToInt(string s) {
    //     unordered_map<char, int> m;

    //     m['M'] = 1000;
    //     m['D'] = 500;
    //     m['C'] = 100;
    //     m['L'] = 50;
    //     m['X'] = 10;
    //     m['V'] = 5;
    //     m['I'] = 1;

    //     int last = m[s[s.length() - 1]];
    //     int result = last;
    //     for (int i = s.length() - 2; i >= 0; i --) {
    //         int current = m[s[i]];
    //         if (current < last) {
    //             result -= current;
    //         } else {
    //             result += current;
    //         }
    //         last = current;
    //     }
    //     return result;
    // }

};