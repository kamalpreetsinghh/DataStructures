package com.cleverdev;

import java.util.LinkedList;

public class HashTable {
    private class Item{
        private final int key;
        private String value;
        Item(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private final LinkedList<Item>[] items;

    HashTable(int size) {
        items = new LinkedList[size];
    }

    public void insert(int key, String value) {
        var item = getItem(key);
        if(item != null) {
            item.value = value;
            return;
        }

        var bucket = getBucket(key);
        if(bucket != null) {
            bucket.add(new Item(key, value));
            return;
        }

        bucket = new LinkedList<>();
        bucket.add(new Item(key, value));
    }

    public String get(int key) {
        var item = getItem(key);

        return item == null ? null : item.value;
    }

    public void remove(int key) {
        var item = getItem(key);
        if(item == null) {
            throw new IllegalStateException();
        }

        getBucket(key).remove(item);
    }

    private int hash(int key) {
        return (key) % items.length;
    }

    private LinkedList<Item> getBucket(int key) {
        return items[hash(key)];
    }

    private Item getItem(int key) {
        var bucket= getBucket(key);
        if(bucket != null) {
            for(var item : bucket) {
                if(item.key == key) {
                    return item;
                }
            }
        }

        return null;
    }
}
