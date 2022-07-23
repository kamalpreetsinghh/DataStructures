package com.cleverdev;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        moveStackOneToStackTwo();
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        moveStackOneToStackTwo();
        return stack2.peek();
    }

    private void moveStackOneToStackTwo() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public void printQueue() {
        Stack<Integer> queueItems = new Stack<Integer>();

        if(!stack2.isEmpty()) {
            int count2 = stack2.lastIndexOf(stack2.peek());

            for(int i = count2; i >=0; i--) {
                queueItems.push(stack2.get(i));
            }
        }

        if(!stack1.isEmpty()) {
            int count1 = stack1.lastIndexOf(stack1.peek());

            for(int i = 0; i <=count1; i++) {
                queueItems.push(stack1.get(i));
            }
        }

        System.out.println(Arrays.toString(queueItems.toArray()));
    }
}
