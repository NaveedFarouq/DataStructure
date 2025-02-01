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
            System.out.print(Arrays.toString(items));
        }
    }

    public void insert(int item) {
        items[count] = item;
        count++;
    }
}
