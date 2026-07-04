package com.DataStructure;

import java.util.Arrays;

public class ArrayStack {

    private int[] items = new int[5];
    private int count = 0;
    public ArrayStack() {

    }

    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }



    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    // method for reversing string
    public static String reverseStr(String str){

        // conver the string to charater set
        char[] chars = str.toCharArray();
        // create new character stack
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        // loop through the array and push each character into the stack
        for (char ch: chars){
            stack.push(ch);
        }
        //  loop through the array and pop each character into char array
        // since this is stack the last element is now push to the first index in the array
        for (int i = 0; i < str.length(); i++){
            chars[i] = stack.pop();
        }
        // return the new array as string;
        return new String(chars);
    }

    // method for printing the next greater element with in an int array.
    // where the next greater is on the right of the array
    public static int[] nextGreaterElement(int[] arr){

        // create new int array to store the elements in
        int[] result = new int[arr.length];
        // create new stack
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // loop through the array from the end
        for (int i = arr.length -1; i >= 0; i--){
            if (!stack.isEmpty()){
                // if stack is not empty and last element in stack is less and and equal to the current index
                // pop the element from the stack
                while (!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            // is stack is empty store -1 in i index of result array
            if (stack.isEmpty()){
                result[i] = -1;
            } else {
                // else store top element from the stack in into current result index
                result[i] = stack.peek();
            }
            // push current array index into stack
            stack.push(arr[i]);
        }
        // return the result array
        return result;
    }

    public static boolean validParenthesisStr(String s){
        // create new stack of characters
        java.util.Stack<Character> stack = new java.util.Stack<>();
        // convert the string into char array
        char[] chars = s.toCharArray();
        // loop through the array
        for (char ch : chars){
            // check if the string are the opening curly if so push to stack
            if (isLeftBracket(ch)){
                stack.push(ch);
            } else {
                // check if stack is empty if so return false as there is no opening bracket
                if (stack.isEmpty()){
                    return false;
                } else {
                    // else store first element in stack to top
                    char top = stack.peek();
                    // compare if the opening has closed parenthesis if so pop them
                    if (bracketIsMatch(ch, top)){
                        stack.pop();
                    } else {
                        // if no closing brackets are found return false
                        return false;
                    }
                }
            }
        }
        // if stack is empty means all elements matched so return true;
        return stack.isEmpty();
    }

    private static boolean bracketIsMatch(char ch, char top) {
        return (ch == ')' && top == '(') ||
                (ch == '}' && top == '{') ||
                (ch == ']' && top == '[');
    }

    public static boolean balancedExpresion(String s){
        // create new stack of characters
        java.util.Stack<Character> stack = new java.util.Stack<>();
        // convert the string into char array
        char[] chars = s.toCharArray();
        // loop through the array
        for (char ch : chars){
            // check if the string are the opening curly if so push to stack
            if (isLeftBracket(ch)){
                stack.push(ch);
            }
            if (isRightBracket(ch)){
                if (stack.isEmpty()){
                    return false;
                }
                var top = stack.pop();
                if (bracketIsNotMatch(ch, top)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean bracketIsNotMatch(char ch, char top) {
        return (ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[') ||
                (ch == '>' && top != '<');
    }
    private static boolean isRightBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }


}
