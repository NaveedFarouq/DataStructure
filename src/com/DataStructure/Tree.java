package com.DataStructure;

import java.util.ArrayList;

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

    public int min(){
        return min(root);
    }
    // O(n)
    // this work for binary tree
    private int min(Node root){
        // if node is leaf node then return its value
        if (root.left == null && root.right == null){
            return root.value;
        }

        var left = min(root.left);
        var right = min(root.right);

        return Math.min(Math.min(left, right), root.value);
    }

    public int minValueInBinarySearchTree(){
        return minValueInBinarySearchTree(root);
    }
    //O(log n)
    private int minValueInBinarySearchTree(Node root){
        if (root == null){
            throw new IllegalArgumentException();
        }
        var current = root;
        while (current.left != null){
            current = current.left;
        }
        return current.value;
    }

    public boolean equals(Tree other){
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;
        if (first  != null && second != null)
            return first.value == second.value && equals(first.left, second.left) && equals(first.right, second.right);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.left, min, root.value -1) &&
                isBinarySearchTree(root.right, root.value + 1, max);
    }

    public ArrayList<Integer> nodeAtKDistanceInTree(int distance){
        // initiating array list to populate with the tree nodes
        ArrayList<Integer> list = new ArrayList<Integer>();
        nodeAtKDistanceInTree(root, distance, list);
        return list;
    }

    private void nodeAtKDistanceInTree(Node root, int distance, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (distance == 0){
            // populating list with node from the tree
            list.add(root.value);
            return;
        }
        //recursions
        nodeAtKDistanceInTree(root.left, distance - 1, list);
        nodeAtKDistanceInTree(root.right, distance - 1, list);
    }

    public void travserLevelOrder(){

        for (int i = 0; i <= height(); i++){
            for (var value : nodeAtKDistanceInTree(i))
                System.out.println(value);
        }
    }


}
