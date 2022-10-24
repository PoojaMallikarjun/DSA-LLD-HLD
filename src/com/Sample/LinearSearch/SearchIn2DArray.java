package com.Sample.LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 4, 7, 8},
                {11, -2, 8},
                {22, 90}
        };
        int target = 90;
        System.out.println(Arrays.toString(linearSearch(arr, target)));
    }

    private static int[] linearSearch(int[][] arr, int target) {
        if(arr.length == 0)
            return new int[]{-1, -1};
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target)
                    return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }
}
