package ru.edu.vtisov.queue;

import ru.edu.vtisov.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/rearrange-string-k-distance-apart

public class RearrangeStringKDistanceApart {

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

        PriorityQueue<Pair<Integer, Character>> free = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey()));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            free.offer(new Pair<>(entry.getValue(), entry.getKey()));
        }

        StringBuilder answer = new StringBuilder();
        LinkedList<Pair<Integer, Character>> busy = new LinkedList<>();
        while (answer.length() != s.length()) {
            int currentLength = answer.length();
            if (!busy.isEmpty() && busy.peek().getKey() <= currentLength) {
                Pair<Integer, Character> pair = busy.remove();
                free.offer(new Pair<>(freq.get(pair.getValue()), pair.getValue()));
            }

            if (free.isEmpty()) {
                return "";
            }

            char current = free.remove().getValue();
            answer.append(current);
            freq.merge(current, -1, Integer::sum);
            if (freq.get(current) > 0) {
                busy.offer(new Pair<>(currentLength + k, current));
            }
        }
        return answer.toString();
    }
}