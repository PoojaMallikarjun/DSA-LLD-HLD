package com.Sample.BinarySearch;

// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=16
// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum13 {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(arr, m));
    }

    static int splitArray(int[] arr, int m) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
//            start will contain the max element from the array, which is the smallest possible answer
            start = Math.max(start, arr[i]);
//            end will contain the max possible answer
            end += arr[i];
        }
//        binary search
        while(start < end) {
//            assuming mid as the potential answer
            int mid = start + (end - start) / 2;
//            calculate how many subArrays the array can be divided into with the subArray's sum as mid
            int sum = 0;
            int subArrayCount = 1;
            for (int n: arr) {
                if(sum + n > mid) {
//                    cannot add the number to the current subArray
//                    The new subArray will start with value n, hence sum = n
                    sum = n;
//                    incrementing the subArray count
                    subArrayCount++;
                } else {
                    sum += n;
                }
            }
            if(subArrayCount > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
//        can return either start or end as start == end
        return start;
    }
}
