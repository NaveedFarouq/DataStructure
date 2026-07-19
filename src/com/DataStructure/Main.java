package com.DataStructure;


import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
       var tree = new Tree();
       tree.insert(10);
        tree.insert(5);
        tree.insert(3);
       tree.insert(15);
       tree.insert(26);

       System.out.println(tree.find(29));

    }


}