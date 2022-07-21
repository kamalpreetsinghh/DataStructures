package com.cleverdev;

public class Array {
    private int[] items;
    private int count = 0;

    public Array(int size) {
        items = new int[size];
    }

    public void insert(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void insertAt(int index, int item) {
        if(index < 0 || index > count)
            throw new IllegalArgumentException();

        System.arraycopy(items, index, items, index + 1, count - index);
        items[index] = item;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();

        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    public int indexOf(int item) {
        for(int i = 0; i < count; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    private void resizeIfRequired() {
        if(count == items.length) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);

            items = newItems;
        }
    }
}
