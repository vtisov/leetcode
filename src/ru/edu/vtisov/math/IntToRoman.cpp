package ru.edu.vtisov.math;

// https://leetcode.com/problems/integer-to-roman

// Greedy algorithm
class Solution {
public:
    string intToRoman(int num) {
        
        vector<pair<int, string>> dictionary = {
            {1000, "M"}, 
            {900, "CM"}, 
            {500, "D"}, 
            {400, "CD"}, 
            {100, "C"}, 
            {90, "XC"}, 
            {50, "L"},
            {40, "XL"},
            {10, "X"},
            {9, "IX"},
            {5, "V"},
            {4, "IV"},
            {1, "I"}
        };

        string result = "";

        for (int i = 0; i < dictionary.size(); i++) {
            while (num >= dictionary[i].first) {
                result += dictionary[i].second;
                num -= dictionary[i].first;
            }
        }
        return result;
    }
};

/*
class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
*/