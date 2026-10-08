package com.DataStructure;

public class AVLTree {

    private Node root;

    private class Node {
        private int height;
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node=" + this.value;
        }

    }

    public void insert(int value){
        root = insert(root, value);
    }
    private Node insert(Node root, int value){
        if (root == null){
            return new Node(value);
        }
        if (value < root.value){
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balanceFactor = height(root.left) - height(root.right);
        if (balanceFactor > 1){
            System.out.println("left heavy");
        } else if (balanceFactor < -1) {
            System.out.println("right heavy");
        }
        return root;
    }

    private int height(Node node){
        return (node == null) ? -1 : node.height;
    }

}
