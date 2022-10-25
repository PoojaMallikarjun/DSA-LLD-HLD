package com.Sample.BinarySearch;

// Find the largest(peak) element's index in a mountain array.
// Mountain Array: [1, 2, 4, 5, 3, 2]
// output: 3(element 5)
// ex2: [1,2,1,3,5,6,4]
// output: 5(element 6)
// array first increases and then decreases.
public class FindPeakInMountainArray8 {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(findPeakIndex(arr));
    }

    private static int findPeakIndex(int[] arr) {
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
        return start;
    }
}
