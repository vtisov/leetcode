package ru.edu.vtisov.hashtable;

// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next(n);
        }
        return n == 1;
    }
    private int next(int n) {
        int answer = 0;
        while (n > 0) {
            answer += (n % 10) * (n % 10);
            n /= 10;
        }
        return answer;
    }

//    public boolean isHappy(int n) {
//        int slow = next(n);
//        int fast = next(next(n));
//        while(slow != 1 && slow != fast) {
//            slow = next(slow);
//            fast = next(next(fast));
//        }
//        return slow == 1;
//    }

}