package com.cleverdev;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        System.out.println(stack.pop());
        System.out.println(stack.toString());
    }
}