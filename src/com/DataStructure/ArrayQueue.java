package com.DataStructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
    }
    public int getLength(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public int peek(){
        return front;
    }
    public boolean isFull(){
        return count == queue.length;
    }

    public void enqueue(int num){
        if (count == queue.length){
            throw new IllegalStateException("queue is full");
        }
        queue[rear] = num;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public void dequeue(){
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;


    }
    @Override
    public String toString() {
        var content = Arrays.copyOfRange(queue, 0, count);
        return Arrays.toString(content);
    }
}
