package com.DataStructure;

import java.util.*;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;   // capacity
    private int size;           // number of key value pairs in hashtable

    public HashTable() {
        this(10); //default capacity
    }
    public HashTable(int capacity){
        this.numOfBuckets = capacity;   // user passed capacity
        buckets = new HashNode[numOfBuckets]; // creating the array of hashnode of size of number of buckets
        this.size = 0;
    }

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void put(Integer key, String value){
        if (key == null || value == null){
            throw new IllegalArgumentException("key or value empty");
        }
        // get the index of the array to store the new key valu pair
        int bucketIndex = getIndex(key);
        // create pointer to the head of linked list
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // increase size
        size++;
        // point head to the head node
        head = buckets[bucketIndex];
        // create new node
        HashNode node = new HashNode(key, value);
        // link new node to head node
        node.next = head;
        // set new node inside the bucket
        buckets[bucketIndex] = node;
    }

    private int getIndex(Integer key) {
        return key % buckets.length;
    }

    public String get(Integer key){
        if (key == null){
            throw new IllegalArgumentException("key is empty");
        }
        int bucketIndex = getIndex(key);
        HashNode head = buckets[bucketIndex];
        String headValue = "Not found";
        while (head != null){
            if (head.key.equals(key)){
                headValue = head.value;
                break;
            }
            head = head.next;
        }
        return headValue;
    }

    public String remove (Integer key){
        if (key == null){
            throw new IllegalArgumentException("key is empty");
        }
        int bucketIndex = getIndex(key);
        // creating pointer to head and previous
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        while (head != null){
            if (head.key.equals(key)){
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null){
            return null;
        }
        size--;
        // check to see if we are breaking the first node if not point previous to head.next
        if (previous != null){
          previous.next = head.next;
        } else {
            // breaking the first node in the chain
            buckets[bucketIndex] = head.next;
        }
        return head.value;
    }

    // using hashmap to get first non-repeating character from string
    public char non_repeatingChar(String msg){
        //create a hash map of key value pair
        Map<Character, Integer> map = new HashMap<>();
        // conver the string to char array and iterate over it
        for (var ch: msg.toCharArray()){
            if (map.containsKey(ch)){
                // set the count for each character in the array
                var count = map.get(ch);
                map.put(ch, count+1);
            } else {
                // else set the char to 1
                map.put(ch, 1);
            }
        }
        // iterate over the char array to return ch or else return the minimum value
        for (var ch: msg.toCharArray()){
            if (map.get(ch) ==1) {
                return ch;
            }
        }
        System.out.println(map);
        return Character.MIN_VALUE;

    }

    // using hashmap to get first repeating character from string
    public char firstRepeatedChar(String msg){
        //create a hash set of value only
        Set<Character> set = new HashSet<>();
        // convert the string to char array and iterate over it
        for (var ch: msg.toCharArray()){
            if (set.contains(ch)) {
                // return char if it is already in the set
                return ch;
            }
            // set the count for each character in the array
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    // using hash map to return most frequent integer in and int array
    public int mostFrequent(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // iterate over the array and set the key value pair in map. where the value is the number of times the
        // integere is repeated.
        for (var i : arr){
            count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        int max = -1;
        int result = arr[0];
        // iterate over the hash map to get the max number of repeated element.
        for (var item: map.entrySet()){
            if (item.getValue() > max){
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }

    public int countPairsWithDiff(int[] arr, int differnce){

        // pass the arr into a hash set
        // hash orders the arr
        HashSet<Integer> set = new HashSet<>();
        for (var num: arr){
            set.add(num);
        }
        // set count variable to count the number of pairs with differece
        var count = 0;

        for (var num: arr){
            if (set.contains(num + differnce)){
                count++;
            }
            if (set.contains(num - differnce)){
                count++;
            }
            // remove element from set so not have duplicates
            set.remove(num);
        }
        return count;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < numbers.length; ++i) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{(Integer)map.get(complement), i};
            }

            map.put(numbers[i], i);
        }

        return null;
    }

    // checking is array of integers contains duplicates
    public boolean containtsDuplicate(int[] numbers){
        HashSet<Integer> set = new HashSet<>();
        for (int i: numbers){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

}
