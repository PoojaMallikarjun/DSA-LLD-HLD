package com.Sample.BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// eg: [2,9,2,2,2]
// For arrays with duplicates
public class SearchInARotatedSortedArrayWithDuplicates11 {
    public static void main(String[] args) {
        int[] arr = {2,9,2,2,2};
        int target = 2;
//        System.out.println(searchTarget(arr, target));
        System.out.println(findPivotWithDuplicates(arr));
    }

    static int searchTarget(int[] arr, int target) {
        int pivot = findPivotWithDuplicates(arr);
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

    static int findPivotWithDuplicates(int[] arr) {
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
//            if(arr[mid] <= arr[start]) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//            If elements at start, mid, end are equal, then skip the duplicates
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
//                Check if start is pivot before skipping
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
//                skip duplicates
                start++;
//                Check if end is pivot before skipping
                if(arr[end] < arr[end - 1]) {
                    return end;
                }
//                skip duplicates
                end--;
            }
//            Left side is sorted so pivot is on the right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else{
                end = mid - 1;
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
