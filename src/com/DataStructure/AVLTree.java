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
        setHeight(root);
        return balance(root);
    }

    private Node balance(Node root){
        if (isLeftHeavy(root)){
            if (balanceFactor(root.left) < 1){
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0){
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }
        return root;
    }

    private Node rotateLeft(Node root){
        var newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }


    private Node rotateRight(Node root){
        var newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
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
