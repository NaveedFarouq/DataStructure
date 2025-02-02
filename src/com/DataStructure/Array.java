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

    public int indexOf(int item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                return i;
            }
        }
//        throw new IllegalArgumentException();
        return -1;
    }

    public int maxNumber() {
        int max = 0;
        for (int item: items) {
           if ( item > max)
               max = item;
        }
        return max;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);
        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        return intersection;
    }

    public void reverse() {
        int[] newItems = new int[count];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[count - i - 1];
        }
        System.out.println(Arrays.toString(newItems));
    }
}
