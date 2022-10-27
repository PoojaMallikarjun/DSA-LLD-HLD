package com.Sample.BinarySearch.SearchIn2DArrays;

import java.util.Arrays;

// Given array is sorted both row-wise and col-wise
// lower bound will be at arr[0][0] --> keep incrementing the row value
// upper bound will be at arr[0][n-1] --> keep decreasing the col value
// Time Complexity: O(M+N)
public class SearchInRowAndColSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},
                {2,4,6,9},
                {11,12,13,14}
        };
        int target = 44;
        System.out.println(Arrays.toString(searchIn2DArray(arr, target)));
    }

    private static int[] searchIn2DArray(int[][] arr, int target) {
        int row = 0;
        int col = arr[0].length - 1;

        while(row < arr.length && col >= 0) {
            if(arr[row][col] == target) {
                return new int[]{row, col};
            } else if(arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }
}
