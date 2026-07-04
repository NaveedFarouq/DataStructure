package com.DataStructure;


import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        int[] arr = {12,3, 2, 7, 11, 15};
        int[] i = hashTable.twoSum(arr, 9);
        System.out.println(i.toString());
    }


}