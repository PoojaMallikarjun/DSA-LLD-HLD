package com.Sample.BinarySearch;

public class FloorOfANumber4 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 10, 99};
        int target = 1;
        System.out.println(findFloorOfGivenNumber(arr, target));
    }

//    Return the largest number <= target
    private static int findFloorOfGivenNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return mid;
            else if(target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }
}
