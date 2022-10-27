package com.Sample.BinarySearch.SearchIn2DArrays;

import java.util.Arrays;

// Sorted Matrix eg: can be n*n or n*m
// [1, 2, 3, 4]
// [5, 6, 7, 8]
// [9, 10, 11, 12]
// [13, 14, 15, 16]
// https://www.youtube.com/watch?v=enI_KyGLYPo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=16
public class SearchInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 10;
        System.out.println(Arrays.toString(searchInSorted2DArray(matrix, target)));
    }

    static int[] searchInSorted2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;
//        run the loop till 2 rows are remaining
        while(rowStart < rowEnd - 1) { // while this is true, there are going to be more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if(matrix[mid][colMid] == target) {
                return new int[]{mid, colMid};
            } else if(matrix[mid][colMid] < target) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }
//        now we have 2 rows remaining
//        check whether the midCol column having 2 rows has the target or not
        if(matrix[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }
        if(matrix[rowStart + 1][colMid] == target) {
            return new int[]{rowStart + 1, colMid};
        }
//        search in first half
        if(colMid - 1 >= 0 && target <= matrix[rowStart][colMid - 1]) {
            return binarySearch(matrix, rowStart, 0, colMid - 1, target);
        }
//        search in second half
        if(colMid + 1 < cols && target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols - 1]) {
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }
//        search in third half
        if(colMid - 1 >= 0 && target <= matrix[rowStart + 1][colMid - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        }
//        search in fourth half
        if(colMid + 1 < cols && target >= matrix[rowStart + 1][colMid + 1]) {
            return binarySearch(matrix, rowStart + 1, colMid + 1, cols - 1, target);
        }
        return new int[]{-1, -1};
    }

//    to search in the row provided between the colStart and colEnd
    static int[] binarySearch(int[][] arr, int row, int colStart, int colEnd, int target) {
        while(colStart <= colEnd) {
//            int mid = (start + end) / 2; --> start+end can exceed int range
            int mid = colStart + (colEnd - colStart) / 2;
            if(arr[row][mid] == target)
                return new int[]{row, mid};
            else if(target > arr[row][mid]) {
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
