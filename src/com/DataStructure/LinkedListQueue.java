package com.DataStructure;

import java.util.*;
import java.util.LinkedList;

public class LinkedListQueue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public LinkedListQueue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    public class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public void print(){
        if (isEmpty())
            System.out.println("null");
        ListNode current = front;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

    }

    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }

    public int first(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return front.data;
    }
    public int last(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return rear.data;
    }

    public void enqueue(int data){
        // create new node
        var node = new ListNode(data);
        // check if queue is empty then set front to new node else link rear to the new node
        if (isEmpty()){
            front = node;
        } else {
            rear.next = node;
        }
        // set rear to new node
        rear = node;
        // increment length
        length++;
    }

    public void dequeue(){
        // check if queue is already empty throw exception
        if (isEmpty())
            throw new NoSuchElementException();
        // move the front to the next element
        front = front.next;
        //if front is empty then set rear to empty aswell to break both links
        if (front == null){
            rear = null;
        }
        //decrement length
        length--;

    }

    // reversing queues
    public static java.util.Queue<Integer> reverse(java.util.Queue<Integer> queue){
        java.util.Stack<Integer> stack = new Stack<>();
        java.util.Queue<Integer> result = new ArrayDeque<>();
        if (queue.isEmpty())
            throw new NoSuchElementException("queue is empty");

        for (Integer q: queue){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }
    // reverse the first k element of queue
    public static Queue<Integer> reverseKElements(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        // put first k elements in the stack
        for (int i = 0; i < k; i++){
            stack.push(queue.poll());
        }
        // add the content of stack at the back of the queue
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        // remove the remaining elements and enqueue them at the end of the queue
        for (int i = 0; i < queue.size() - k; i++){
            queue.add(queue.poll());
        }

        return queue;

    }
    // generating n number of binary numbers using queue
    public String[] generateBinaryNumbers(int num){
        String[] result = new String[num];
        java.util.Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < num; i++){
            result[i] = q.poll();
            String n1 = result[i] + 0;
            String n2 = result[i] + 1;
            q.offer(n1);
            q.offer(n2);
        }
        return result;

    }


}
