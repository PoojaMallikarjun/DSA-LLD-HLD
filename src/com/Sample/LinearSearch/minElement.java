package com.Sample.LinearSearch;

public class minElement {
    public static void main(String[] args) {
        int[] arr = {2, -8, 4, -44, 8};
        System.out.println(minElement(arr));
    }

    static int minElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element: arr) {
            if( element < min)
                min = element;
        }
        return min;
    }
}
