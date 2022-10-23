package com.Sample.BinarySearch;

// Given a sorted array of integers, find the ceiling number(number that is greater than or equal to the given number)
// [2, 4, 7, 9], target = 8
// ans = 9
// if target = 7
// ans = 7
public class CeilingOfANumber3 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 99};
        int target = 66;
        System.out.println(findCeilingNumber(arr, target));
    }

    private static int findCeilingNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return mid;
            if(target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
