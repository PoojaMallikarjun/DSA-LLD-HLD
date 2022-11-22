package com.Sample.BinarySearch.Assignments.Hard;

// https://www.youtube.com/watch?v=gYmWHvRHu-s
// https://www.geeksforgeeks.org/allocate-minimum-number-pages/
public class AllocateMinNoOfPages {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 34, 67, 90};
        int m = 2;
        System.out.println(allocateMinPages(arr, arr.length, m));
    }

    private static int allocateMinPages(int[] arr, int n, int s) {
        int low = arr[0];
        int high = sum(arr);
        int res = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(isAllocationPossible(arr, n, s, mid)) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isAllocationPossible(int[] arr, int n, int s, int barrier) {
        int pages = 0;
        int studentsAllocated = 1;

        for(int i = 0; i < n; i++) {
            if(arr[i] > barrier) {
                return false;
            }
            if(pages + arr[i] > barrier) {
                studentsAllocated++;
            }
            pages += arr[i];
        }
        if(studentsAllocated > s) {
            return false;
        }
        return true;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i< arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
