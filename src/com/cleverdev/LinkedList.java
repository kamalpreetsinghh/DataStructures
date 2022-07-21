package com.cleverdev;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        Node newNode = new Node(item);

        if(isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size ++;
    }

    public void addLast(int item) {
        Node newNode = new Node(item);

        if(isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size ++;
    }

    public void removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
        } else {
            Node previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }

        size--;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while(current != null) {
            if(current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        Node current = first;

        while(current != null) {
            if(current.value == item) {
                return true;
            }
            current = current.next;
        }

        return false;
    }
    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while(current != null) {
            if(current.next == node) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    private int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while(current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }

    private void reverse() {
        // 10 -> 20 -> 30
        // 10 <- 20 <- 30
        // p     c     n
        Node previous = first;
        Node current = first.next;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }
}


