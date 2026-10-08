package com.DataStructure;


public class Main {


    public static void main(String[] args) {
       var tree = new AVLTree();
       tree.insert(10);
       tree.insert(20);
       tree.insert(5);
       tree.insert(25);
       tree.insert(30);
    }

    public static int factorial(int n ){
        // base check
        if (n == 0){
            return 1;
        }
        return n * factorial(n -1);
    }


}