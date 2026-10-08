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
        balance(root);
        return root;
    }

    private void balance(Node root){
        if (isLeftHeavy(root)){
            if (balanceFactor(root.left) < 1){
                System.out.println("left rotate" + root.left.value);
            }
            System.out.println("right rotate" + root.value);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0){
                System.out.println("right rotate" + root.right.value);
            }
            System.out.println("left rotate" + root.value);
        }

    }
    private boolean isLeftHeavy(Node node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(Node node){
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(Node node){
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    private int height(Node node){
        return (node == null) ? -1 : node.height;
    }

}
