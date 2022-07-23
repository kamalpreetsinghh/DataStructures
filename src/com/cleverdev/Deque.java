package com.cleverdev;

public class Deque {
    private final int[] items;
    private int front;
    private int rear;
    private final int size;

    Deque(int size) {
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueueFront(int item) {
        if(isFull()) throw new StackOverflowError();

        if(front == -1) {
            front = rear = 0;
        } else if(front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        items[front] = item;
    }

    public void enqueueRear(int item) {
        if(isFull()) throw new StackOverflowError();

        if(front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        items[rear] = item;
    }

    public int dequeueFront() {
        if(isEmpty()) throw new IllegalStateException();

        int item = items[front];

        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return item;
    }

    public int dequeueRear() {
        if(isEmpty()) throw new IllegalStateException();
        int item = items[rear];

        if(front == rear) {
            front = rear = -1;
        } else if(rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }

        return item;
    }

    public int peekFront() {
        if(isEmpty()) throw new IllegalStateException();

        return items[front];
    }

    public int peekRear() {
        if(isEmpty()) throw new IllegalStateException();

        return items[rear];
    }

    public boolean isFull() {
        if(front == 0 && rear == size -1) {
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
