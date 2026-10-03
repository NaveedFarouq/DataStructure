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
        //base check
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
        // put a pointer to the root element
        var current = root;
        // while curren pointed item/node is not null
        while (current != null) {
            if (current.value == value) {
                return current.value;
            } else if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            }
        }
        // if value cannot be found then return -1
        return -1;
    }

    //overloading the below method to hide implementation details
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if (root == null){
            return;
        }
        traverseInOrder(root.left);
        System.out.println(root.value);
        traverseInOrder(root.right);

    }
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if (root == null){
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root.value);

    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if (root  == null){
            return -1;
        }
        if (root.left == null && root.right == null){
            return 0;
        }
        return 1 + Math.max(
                height(root.left), height(root.right));
    }
}
