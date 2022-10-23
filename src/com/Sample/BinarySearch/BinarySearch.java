package com.Sample.BinarySearch;

//
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 5 , 12, 89};
        int target = 112;
        System.out.println(binarySearch(arr, target));
    }

//    return index
//    return -1 if element not found
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
//            int mid = (start + end) / 2; --> start+end can exceed int range
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
