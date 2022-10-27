package com.Sample.BinarySearch.Assignments.Easy;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 5, 11}, 5));
    }
    static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]-mid-1 < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start + k;
    }
}
