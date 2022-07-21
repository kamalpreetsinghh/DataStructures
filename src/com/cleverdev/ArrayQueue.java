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

        if(front == rear && front == -1) {
            front = rear = 0;
            items[rear] = item;
        } else {
            items[++rear] = item;
        }
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        return items[front++];
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1) || front > rear;
    }

    public boolean isFull() {
        return rear == items.length -1;
    }

    public String toString() {
        return Arrays.toString(items);
    }
}
