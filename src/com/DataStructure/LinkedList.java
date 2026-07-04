package com.DataStructure;

import com.sun.source.tree.WhileLoopTree;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printLinkedList(LinkedList list){
        // point the current to head element of linked list or firs element
        Node current = first;
        // traverse the list as long as curren is not null
        while (current != null){
            // print the values
            System.out.println(current.value);
            // point the head to the next element for further printing
            current = current.next;
        }
    }

    // method to add element to the beginning of list
    public void addFirst(int value){
        // create new node
        var node = new Node(value);
        // check if firs is null
        if (first == null){
            // if so then set node to first and node address to null is this will be the first
            first = last =  node;
        } else {
            first.next = node;
            first = node;
        }
    }
    // method to add element to the end of list
    public void addLast(int value){
        // create new node
        var node = new Node(value);
        // check if firs is null
        if(first == null){
            // if so then set node to both first and last
            first = last = node;
        } else {
            // else point last address to node and set node to last
            last.next = node;
            last = node;
        }
    }

    // addLast if tail/last is not known
    public void addLastOptionIfTailIsNotKnown(int value){
        // create new node
        var node = new Node(value);
        // check if firs is null
        if(first == null){
            // if so then set node to both first and last
            first = node;
            return;
        }
        // create reference to head
        Node current = first;
        // loop through the list to find the last element
        while (current != null){
            current = current.next;
        }
        // set the reference of last element to new node
        current.next = node;
    }

    // method to deleteFirst element of list
    public void deleteFirst(){
        // check if first element is null or not
        if (first == null){
            throw new NoSuchElementException();
        }
        // check if there is only one element
        if (first == last){
            first = last = null;
            return;
        }
        // make a reference to second element and then set firs to second.
        Node second = first.next;
        first.next = null;
        first = second;
    }
    // method to deleteLast element of list
    public void deleteLast(){

        // check if first element is null or not
        if (first == null){
            throw new NoSuchElementException();
        }
        // check if there is only one element
        if (first == last){
            first = last = null;
            return;
        }

        // create reference to first
        Node current = first;
        Node previous = null;
        // loop through the list to find the last element
        while (current != null){
            if (current.next == last){
                // if element is found store to previous
                previous = current;
                // set previous to last
                last = previous;
                // remove the link last
                last.next = null;
            }
            current = current.next;
        }
    }
    // method for checking value exists in list - contains
    public boolean contains(int value){
        Node current = first;
        while (current != null){
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // method to find index of eleent in a list
    public int indexOf(int value){
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value == value){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // find the length of linked list
    // We can also set a variable which increases or decreases everytime we add or delete node
    // that will be a lot more efficient when building linked lists but if it doesn't exist then we can use below method
    public int sizeOfLinkedList(LinkedList list){
        Node current = first;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    // converting linked list to array
    public int[] toArray(LinkedList list){
        // create new array and set the size of the array as size of the linked list
        // using the existing method of getting the size of the array
        int[] array = new int[list.sizeOfLinkedList(list)];
        // create reference to the first node
        Node head = first;
        // create reference to the array index
        int index = 0;
        // loop through the array
        while (head != null){
            // set the value of node to the array
            array[index] = head.value;
            // increment index count and point to the next node
            index++;
            head = head.next;
        }
        return array;
    }

    // reversing linked list
    public int[] reverseSLL(LinkedList list){
        // reference first element
        Node firstl = first;
        // reference second element
        Node second = first.next;

        // set the last to first before we loop
        last = firstl;
        last.next = null;

        // loop on the list where second does not equal to null
        // [10, 20, 30, 40, 50]
        //      f    s   t
        while (second != null){
            // create reference to third element
            Node third = second.next;
            // change addres of second element to point to first
            second.next = firstl;
            // store second into first
            firstl = second;
            // store third into second
            second = third;

        }
        // point first/head back to new first as after the loop firstl is now pointing to last element
        first = firstl;
        // return array
        return toArray(list);
    }

    // method to insert a node at given position
    public void insertNodeAtGivenPosition(int value, int position){
        // create the new node
        Node newNode = new Node(value);
        if (first == null){
            first = newNode;
            return;
        }
        // if position is one then point the address to first and set the new node to first
        if (position == 1){
            newNode.next = first;
            first = newNode;
        } else {
            // create reference to head
            Node current = first;
            // set count assuming position is greater than one
            int count = 1;
            // loop through the array to find the position
            while (count < position - 1) {
                current = current.next;
                count++;
            }
            // create reference to the next element within the list
            Node next = current.next;
            // point the new node to the current element
            newNode.next = next;
            // link the new node back to the list
            current.next = newNode;
        }

    }
     public void deleteNodeAtGivenPosition(int position) {
        // check if head is null end method
        if (first == null){
            return;
        }
        // check if positio is one then set head to the next element
        if (position == 1 ){
            first = first.next;
        } else {
            // create referent to head and previous element
            Node current = first;
            Node previous = null;
            // set count to mark position
            int count = 1;
            // loop through to get to the right position
            while (count < position) {
                // move previous to and current forward
                previous = current;
                current = current.next;
                count++;
            }
            // set previous link to new element to break the links
            previous.next = current.next;

        }

     }

     // searching for an element in singly linked list if it exists return true else false
     public boolean searchElementInSLL(int num){
        Node head = first;
        while (head != null){
            if (head.value == num){
                return true;

            }
            head = head.next;
        }
        return false;
     }
     //reversing a sll
     // second way - dinesh viryani
     // [10, 20, 30, 40, 50]
    public int[] reversingSLL(LinkedList list){
        Node current = first;
        Node next = null;
        Node previous = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            first = previous;
        }
        return toArray(list);
    }

    // finding middle node to in a SLL
    // first way
    public double middleNodeInSLL(LinkedList list){
        double index = 0;
        Node current = first;
        while (current != null){
            current = current.next;
            index++;
        }
        if (index % 2 == 0){
            index = index/2 + 1;
        } else {
            index = index/2 + 0.5;
        }
        return index;
    }

    // finding middle node in a SLL
    // second way - dinesh viryani
    // [10, 20, 30, 40, 50, 60, 70]
    //          c            s
    public int findingMiddleNode(LinkedList list){
        Node current = first;
        Node second  = first;
        int middle;
        while (second != null && second.next != null){
            current = current.next;
            second = second.next.next;
        }
        return middle = current.value;
    }

    // finding the kth element of a singly linked list - Dinesh Viryani
    // [10, 20, 30]
    //  c       n
    public int getKthFromTheEnd(int num){
        if (first == null){
            return -1;
        }

        Node current = first;
        Node next = first;
        int count = 0;
        while (count < num){
            next = next.next;
            count++;
        }
        while (next != null){
            next = next.next;
            current = current.next;
        }
        return current.value;

    }
    // finding the kth element of a singly linked list - Mosh
    // [10, 20, 30]
    public int getKthFromTheEndMOsh(int num){
        Node current = first;
        Node next = first;
        for (int i = 0; i < num -1; i++){
            next = next.next;
            if (next == null){
                throw new IllegalArgumentException();
            }
        }
        while (next != null){
            next = next.next;
            current = current.next;
        }
        return current.value;

    }

    // removing duplicates in a sorted linked list
    //[1, 1, 2, 4, 4]
    //          c  n
    public void removeDuplicate(){
        Node current = first;
        while (current != null && current.next != null){
            if (current.value == current.next.value){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

    }
    // insert node in a sorted SLL
    //  [2, 4, 6, 10, 14]
    //                 p   c
    // my own solution
    public void insertNodeInSortedSLL(int num){
        Node newNode = new Node(num);
        if (first.value > newNode.value){
            newNode.next = first;
            first = newNode;
        }
        Node current = first;
        Node previous = first;
        while (current != null){
            if (current.value > newNode.value){
                previous.next = newNode;
                newNode.next = current;
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == null){
            previous.next = newNode;
            newNode.next = current;
        }
    }

    // Dinesh Viryani solution; much simplet and better
    public void insertNodeInSLL(int num){

        Node newNode = new Node(num);
        if (first == null){
            first =  newNode;
        }
        Node current = first;
        Node temp = null;
        while (current != null && current.value < newNode.value){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;

    }

    // remove a given key in a SLL - my solution
    // [3, 5, 8, 23]
    //  c
    public void removeGivenKeyinSLL(int num){
        if (first.value == num){
            first = first.next;
            return;
        }
        Node current = first;
        while (current.next != null && current.next.value != num){
                current = current.next;
        }
        current.next = current.next.next;
    }
    // Dinesh Viryani solution
    public void remoeGivneKeySLL(int key){

        Node current = first;
        Node temp = null;
        if (current != null && current.value == key){
            first = current.next;
            return;
        }
        while (current != null && current.value != key){
            temp = current;
            current = current.next;
        }
        if (current == null){
            return;
        }
        temp.next = current.next;
    }

}
