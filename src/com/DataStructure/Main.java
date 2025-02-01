package com.DataStructure;

public class Main {
    public static void main(String[] args) {

        Array number = new Array(3);
        number.insert(10);
        number.insert(20);
        number.insert(30);
        number.insert(40);
//        number.delete(5);
        System.out.println(number.indexOf(50));
        number.print();
    }
}