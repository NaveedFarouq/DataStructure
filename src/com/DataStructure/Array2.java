package com.DataStructure;

public class Array2 {

    private int[] items;
    private int count;

    public Array2(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i]);
        }
    }

    public void insert(int number) {
        //check size of array
        if (items.length == count) {
            //create new array
            int[] newItem = new int[count * 2];
            //copy existing array to new array
            for (int i = 0; i < count; i++){
                newItem[i] = items[i];
            }
            //set new items to this array
            items = newItem;
        }
        items[count++] = number;
    }

    public void removeAt(int index){
        //validate the index
        if (index < 0 || index >= count){
            throw new IllegalArgumentException();
        }

        //loop through the array move the next item into the previous index place
        //[1, 2, 3, 4]
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int number){
        // loop through the aray check for the index of the number
        for (int i = 0; i < count; i++)
            if (items[i] == number)
                return i;
        return -1;
    }

    public int maxNumber(){
        // loop through the array
        // find the max by comparing
        // then return max
        // [10, 60, 30, 50]
        int max = 0;
        for (int i = 0; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public int[] intersect(int[] item2){
        int[] intersect = new int[count + item2.length];
        for (int i = 0; i < item2.length; i++){
            for (int j = 0; j < count; j++) {
                if (item2[i] == items[j])
                    intersect = new int[]{item2[i]};
                return intersect;
            }

        }

        return new int[]{0};

    }

}
