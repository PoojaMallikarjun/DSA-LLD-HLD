package com.Sample.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {50, 3, 2, 5, 8, 1};
        int target = 5;
        int index = search(arr, target);
        if(index == -1)
            System.out.println("Element not found!");
        else
            System.out.println("element found at index: " + index);
    }

    private static int search(int[] arr, int target) {
        if(arr.length == 0)
            return -1;
        for(int i = 0; i < arr.length; i ++) {
            if(target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
