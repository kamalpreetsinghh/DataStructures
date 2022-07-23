package com.cleverdev;

import java.util.Arrays;

public class PriorityQueue {
    private final int[] items;
    private int count;

    PriorityQueue(int size) {
        items = new int[size];
    }

    public void enqueue(int item) {
        if(isFull()) throw new StackOverflowError();

        int i;
        for(i = count - 1; i >= 0; i--) {
            if(items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }

        items[i] = item;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public String toString() {
        return Arrays.toString(items);
    }
}
