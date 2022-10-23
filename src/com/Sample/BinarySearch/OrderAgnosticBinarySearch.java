package com.Sample.BinarySearch;

// When the given array is sorted but the order of sorting(ASC or DESC) is not known
// In that case to identify the order of sorting in the given sorted array can be identified by finding
// arr[0] is greater of lesser than arr[n-1]
public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {100, 7, 6, 1};
        int target = 1;
        System.out.println(orderAgnosticBinarySearch(arr, target));
    }

    private static int orderAgnosticBinarySearch(int[] arr, int target) {
        boolean isAsc = arr[0] < arr[arr.length - 1];

        int start = 0;
        int end = arr.length - 1;

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
