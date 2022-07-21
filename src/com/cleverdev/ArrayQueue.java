package com.cleverdev;

import java.util.Arrays;

public class ArrayQueue {
    private final int[] items;
    private int front;
    private int rear;

    ArrayQueue(int size) {
        items = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int item) {
        if(isFull()) throw new StackOverflowError();

        if(front == -1)
            front = 0;

        items[++rear] = item;
    }

    public int dequeue() {
        int item;
        if(isEmpty()) throw new IllegalStateException();
        item = items[front];
        if(front >= rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return item;
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return rear == items.length -1;
    }

    public String toString() {
        return Arrays.toString(items);
    }
}
