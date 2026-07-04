package com.DataStructure;

import java.util.Arrays;

public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public void insert(int item) {
        if (items.length == count) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[count] = item;
        count++;
    }

    public void delete(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                return i;
            }
        }
//        throw new IllegalArgumentException();
        return -1;
    }

    public int maxNumber() {
        int max = 0;
        for (int item: items) {
           if ( item > max)
               max = item;
        }
        return max;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);
        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        return intersection;
    }

    public void reverse() {
        int[] newItems = new int[count];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[count - i - 1];
        }
        System.out.println(Arrays.toString(newItems));
    }

    public static int[] removeEvenNumbers(int[] arr){
        // create count variable to know how many odd number there are
        int count = 0;
        // traverse the array to find number of odd number
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                count++;
            }
        }
        // create new array with the size of odd numbers
        int[] OddNumbers = new int[count];
        // define index of the new array oddNumebrs
        int index = 0;
        // traverse the array again for odd numbers and copy and paste them in the new array
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                OddNumbers[index++] = arr[i];
            }
        }
        // return new array
        return OddNumbers;
    }

    public static int[] reverseArray(int[] arr){
        // define start and end of the array
        int start = 0;
        int end = arr.length - 1;
        // loop through the array
        while (start < end){
            //create temp variable and assing value of start
            int temp = arr[start];
            //copy end to positions of start
            arr[start] = arr[end];
            // paste temp value to end of array
            arr[end] = temp;
            // increment start and decrement end points.
            start++;
            end--;
        }
        return arr;
    }

    public static int findMinimumValueInArray(int[] arr){
        // create new variable of for min value set the first element of array
        int min = arr[0];
        // traverse the array
        for (int i = 0; i < arr.length; i++){
            // compare new index value vs min
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;

    }

    public static int findSecondMinimumValueInArray(int[] arr){
        // create new variable of for min value set the first element of array
        int min = arr[0];
        int SecondMin = arr[0];
        // traverse the array
        for (int i = 0; i < arr.length; i++){
            // compare new index value vs min
            if (arr[i] <= min){
                min = arr[i];
                //set the second min is i +1
                SecondMin = arr[i + 1];
            }
        }
        // traverse again and compare min vs secondMin
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > min && arr[i] < SecondMin){
                SecondMin = arr[i];
            }
        }

        return SecondMin;

    }

    public static int findSecondMaximumValueInArray(int[] arr){
        // create new variable of for min value set the first element of array
        int max = arr[0];
        int SecondMax = arr[0];
        // traverse the array
        for (int i = 0; i < arr.length; i++){
            // compare new index value vs min
            if (arr[i] > max){
                SecondMax = max;
                max = arr[i];
            }
            //compare max vs second max
            else if (arr[i] > SecondMax && arr[i] != max){
                SecondMax = arr[i];
            }
        }
        // solution 2
        // traverse again and compare min vs secondMin
        // for (int i = 0; i < arr.length; i++){
        //     if (arr[i] < max && arr[i] > SecondMax){
        //       SecondMax = arr[i];
        //     }
        //   }

        return SecondMax;

    }

    public static int[] Move0stoEnd(int[] arr){
        //mark pointer to count 0 elements
        int j = 0;
        // traverse the array
        for (int i = 0; i < arr.length; i++){
            //chek for value of I and J
            if (arr[i] != 0 && arr[j] == 0){
                // do the swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            } if (arr[j] != 0){
                // incremet the j to count number of zeros
                j++;
            }

        }

        return arr;
    }
    public static int findMissingNumber(int[] arr) {
        // Use long to prevent integer overflow when multiplying large numbers
        long n = arr.length;
        long expectedSum = n * (n + 1) / 2;

        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Cast back to int at the very end
        return (int) (expectedSum - actualSum);
    }

    public static boolean checkingWordIsPalindrome(String word){
        // convert the word into char array
        char[] charArray = word.toCharArray();
        // track the start and end of the array
        int start = 0;
        int end = charArray.length - 1;
        // loop through the array
        while (start < end){
            //compare the letters are the same else return false
            if(charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
