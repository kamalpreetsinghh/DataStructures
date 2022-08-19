package com.cleverdev;

public class CircularQueue {
    private final int[] items;
    private int front;
    private int rear;
    private final int size;

    CircularQueue(int size) {
        this.size = size;
        items = new int[size];
        front = rear = -1;
    }

    public void enqueue(int item) {
        if(isFull()) throw new StackOverflowError();

        if(front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        items[rear] = item;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        int item = items[front];

        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return item;
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        return items[front];
    }

    public boolean isFull() {
        if(front == 0 && rear == size - 1) {
            return true;
        }

        if(front == rear + 1) {
            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        return front == -1;
    }
}
