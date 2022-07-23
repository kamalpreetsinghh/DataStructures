package com.cleverdev;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.enqueue(23);
        queue.dequeue();
        queue.printQueue();
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
    }
}