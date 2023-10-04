package ru.edu.vtisov.hashtable;

import ru.edu.vtisov.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

// https://leetcode.com/problems/design-hashmap

public class MyHashMap {

    private static final int N = 16;
    private final List<TreeSet<Pair<Integer, Integer>>> buckets;

    public MyHashMap() {
        this.buckets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            buckets.add(new TreeSet<>(Comparator.comparingInt(Pair::getKey)));
        }
    }

    public void put(int key, int value) {
        buckets.get(key % N).remove(new Pair<>(key, value));
        buckets.get(key % N).add(new Pair<>(key, value));
    }

    public int get(int key) {
        TreeSet<Pair<Integer, Integer>> set = buckets.get(key % N);
        Pair<Integer, Integer> pair = new Pair<>(key, 0);
        Pair<Integer, Integer> ceil = set.ceiling(pair); // least elt >= key
        Pair<Integer, Integer> floor = set.floor(pair);   // highest elt <= key
        if (floor == null || ceil == null) return -1;
        return ceil.equals(floor) ? ceil.getValue() : -1;
    }

    public void remove(int key) {
        buckets.get(key % N).remove(new Pair<>(key, 0));
    }
}
