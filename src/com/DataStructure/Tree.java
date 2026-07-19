package com.DataStructure;

public class Tree {

    public class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value){
        // create new node with the value passed
        var node = new Node(value);
        // if no root then new node as root.
        if (root == null){
            root = node;
            return;
        }

        // reference to the root node
        var current = root;
        while (true) {
            // compare value to the roots  value; if less than go to left if more than go to right
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;

            } else if (value > current.value) {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }

    }

    public int find(int value) {
        var current = root;
        while (current != null) {
            if (current.value == value) {
                return current.value;
            } else if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            }
        }
        return -1;
    }
}
