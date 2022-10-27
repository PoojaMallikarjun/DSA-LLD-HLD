package com.Sample.BinarySearch.Assignments.Easy;

// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }

    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
