package com.Sample.BinarySearch;

import java.util.Arrays;

// Given an array of integers arr sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.
// If arr = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// If arr = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Run Binary search twice->one to find start index, next to find the last index
public class FindFirstAndLastPositionOfTargetInArray6 {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(findFirstAndLastIndexOfTarget(arr, target)));
    }

    private static int[] findFirstAndLastIndexOfTarget(int[] arr, int target) {
        int ans[] = {-1, -1};
        ans[0] = binarySearch(arr, target, true);
        if(ans[0] != -1)
            ans[1] = binarySearch(arr, target, false);
        return ans;
    }

    private static int binarySearch(int[] arr, int target, boolean findStart) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid])
                end = mid - 1;
            else if(target > arr[mid])
                start = mid + 1;
            else {
                ans = mid;
                if(findStart)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }

    private static int[] bruteForce(int[] arr, int target) {
        if(arr.length == 0)
            return new int[]{-1, -1};
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != target)
                continue;
            if(start == -1)
                start = i;
            end = i;
        }
        if(start != -1)
            return new int[]{start, end};
        else
            return new int[]{-1, -1};
    }
}
