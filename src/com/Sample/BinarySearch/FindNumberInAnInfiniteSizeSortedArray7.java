package com.Sample.BinarySearch;

// Let's imagine the length of the array cannot be calculated for an infinite size array
// Time Complexity is O(logN) --> just Binary Search
public class FindNumberInAnInfiniteSizeSortedArray7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 44, 55, 66, 88, 355};
        int target = 88;
        System.out.println(findIndexOfTarget(arr, target));
    }

    static int findIndexOfTarget(int[] arr, int target) {
//        Since the size of the array is unknown we will have to process the elements in chunks
//        Let the initial chunk size be 2. Keep doubling the size of the chunk on each iteration
//        Run a loop to identify if the target exists within a given chunk or not
        int start = 0;
        int end = 1;
//        If target is greater than element at end, then the target is not within the current chunk. Hence, increment start
//        and end to obtain new chunk.
        while(target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
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
