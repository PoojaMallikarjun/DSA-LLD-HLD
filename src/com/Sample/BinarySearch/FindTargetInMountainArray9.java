package com.Sample.BinarySearch;

// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
// If such an index does not exist, return -1.
//
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Input: array = [1,2,3,4,5,3,1], target = 3
// Output: 2
// Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
public class FindTargetInMountainArray9 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 0};
        int target = 0;
        System.out.println(findTargetIndex(arr, target));
    }

//    Find the peak index first. Apply binary search from start to peak index and peak index to end index.
//    User order agnostic Binary search to find target in both sections of the array.
    private static int findTargetIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
//            In the decreasing part of the array, hence look at the left part of the array
            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            }
//            In ascending part of the array, hence look at the right part of the array
            else {
                start = mid + 1;
            }
        }
//        When start == end, both of them will be pointing at the peak element
//        both start and end are trying to find the largest element, hence when they both point at the same
//        element it will the largest element.
        int peakIndex = start;
        int targetIndex = orderAgnosticBinarySearch(arr, target, 0, peakIndex);
        if(targetIndex != -1) {
            return targetIndex;
        }
        else return orderAgnosticBinarySearch(arr, target, peakIndex + 1, arr.length - 1);
    }

    private static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target > arr[mid]) {
                if(isAsc)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if(isAsc)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
