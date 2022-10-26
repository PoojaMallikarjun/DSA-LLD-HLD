package com.Sample.BinarySearch;

// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=16
// The count would just be the position of pivot element+1.
public class RotationCountInRotatedSortedArray12 {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 5, 6, 0, 1, 2, 3};
        int[] arr = {3, 4, 5, 6, 0, 1, 2};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr) {
        int pivot = findRotationCount(arr);
        return pivot + 1;
    }

//    use this for array with no duplicates
    private static int findRotationCount(int[] arr) {
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

    private static int findRotationCountWithDuplicates(int[] arr) {
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
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if(arr[end] > arr[end - 1]) {
                    return end;
                }
                end--;
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[end] < arr[mid])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
