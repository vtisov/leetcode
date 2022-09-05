package ru.edu.vtisov.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    
    private final PriorityQueue<Integer> left;
    private final PriorityQueue<Integer> right;

    public FindMedianFromDataStream() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        return left.size() > right.size() ? left.peek() : ((double) left.peek() + right.peek()) / 2;
    }
}
