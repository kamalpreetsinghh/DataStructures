package com.cleverdev;

import java.util.Arrays;

public class Stack {
    private final int[] stack;
    private int top;

    Stack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int item) {
        if(isFull()) throw new StackOverflowError();

        stack[++top] = item;
    }

    public int pop() {
        if(isEmpty()) throw new IllegalStateException();

        return stack[top--];
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public String toString() {
        int[] arr = Arrays.copyOfRange(stack,0, top + 1);
        return Arrays.toString(arr);
    }

}
