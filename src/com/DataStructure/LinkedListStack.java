package com.DataStructure;

import java.util.EmptyStackException;

public class LinkedListStack {

    private Node top;
    private int length;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedListStack(){
        top = null;
        length = 0;
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        if (length == 0){
            return true;
        }
        return false;
    }
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    public int pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.value;
        top = top.next;
        length--;
        return result;

    }
    public int peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }




}
