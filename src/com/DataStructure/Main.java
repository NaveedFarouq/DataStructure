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

        Array number2 = new Array(3);
        number2.insert(10);
        number2.insert(20);
        number2.insert(60);
        number2.insert(80);

        number2.intersect(number2);

        System.out.println();
    }
}