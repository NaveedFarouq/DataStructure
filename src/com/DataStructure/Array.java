package com.DataStructure;

import java.util.Arrays;

public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public void insert(int item) {
        if (items.length == count) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[count] = item;
        count++;
    }

    public void delete(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;

    }
}
