package com.DataStructure;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity){
        this.items = new int[capacity];
    }

    public void add(int item){
        if (count == items.length){
            throw new IllegalStateException();
        }
        int i = shiftItemsToInsert(item);
        items[i + 1] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--){
            if (items[i] > item){
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i;
    }

    public int remove(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
