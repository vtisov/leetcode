package ru.edu.vtisov.stack;

import java.util.LinkedList;

// https://leetcode.com/problems/min-stack/

public class MinStack {

    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> min;
    
    public MinStack() {
        this.stack = new LinkedList<>();
        this.min = new LinkedList<>(); 
    }
    
    public void push(int val) {
        stack.add(val);
        min.add(Math.min(val, min.size() > 0 ? min.getLast() : val));
    }
    
    public void pop() {
        min.removeLast();
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}