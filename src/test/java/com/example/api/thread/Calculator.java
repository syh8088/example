package com.example.api.thread;

public class Calculator {
    private int index;

    public Calculator(int index) {
        this.index = index;
    }

    public synchronized int getNextIndex() {
        return ++index;
    }

    public int getIndex() {
        return index;
    }
}
