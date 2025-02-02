package com.DataStructure;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Array number = new Array(3);
        number.insert(10);
        number.insert(20);
        number.insert(30);
        number.insert(40);

        System.out.println(number.maxNumber());
        System.out.println();
    }
}