package com.Sample.BinarySearch;

// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
// The count would just be the position of pivot element+1.
public class RotationCountInRotatedSortedArray12 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 0, 1, 2, 3};
        System.out.println(findRotationCount(arr));
    }

    private static int findRotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) {
//                the count will be position + 1 as indices are 0 based
                return mid + 1;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
//                the count will be position + 1 as indices are 0 based(mid - 1 + 1)
                return mid;
            }
            if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
//        If the array is sorted but not rotated, the rotation count would be 0.
        return 0;
    }
}
