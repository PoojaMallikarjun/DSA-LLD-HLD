package com.Sample.BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// eg: [3,4,5,6,7,0,1,2]
// Not for arrays with duplicates
// Approach 1: Identify pivot as 7. Apply Binary search on the 2 segments of the array.(0,pivot) and (pivot+1, n-1)
// Approach 2: Using Recursion --> check recursion folder
public class SearchInARotatedSortedArray10 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,0,1,2};
        int target = 6;
        System.out.println(searchTarget(arr, target));

    }

    static int searchTarget(int[] arr, int target) {
        int pivot = findPivot(arr);
//        If pivot is not found, it means the array is not rotated. Hence, apply basic Binary Search
        if(pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if(arr[pivot] == target) {
            return pivot;
        }
        if(target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }
        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid])
                end = mid - 1;
            else if(target > arr[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
