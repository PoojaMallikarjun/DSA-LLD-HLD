package com.Sample.BinarySearch.Assignments.Easy;

// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
// check last two successful submissions
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {
        int start=0;
        int end =nums.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            int count =0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>=mid){
                    count++;
                }
            }
            if(count==mid){
                return mid;
            }else if(count <mid){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
