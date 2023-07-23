package ru.edu.vtisov.util;

public class Pair<T, Y> {

    private final T t;
    private final Y y;

    public Pair(T t, Y y) {
        this.t = t;
        this.y = y;
    }

    public T getKey() {
        return t;
    }

    public Y getValue() {
        return y;
    }
}
