package com.Sample.BinarySearch.Assignments.Easy;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    static int[] twoSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            if(arr[start] + arr[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if(arr[start] + arr[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
