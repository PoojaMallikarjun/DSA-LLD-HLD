package com.Sample.BinarySearch.Assignments.Easy;

// https://leetcode.com/problems/valid-perfect-square/
// same as finding square root of a number
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

    static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(mid * mid == num) {
                return true;
            }
            if(mid * mid < num) {
                start = (int)mid + 1;
            } else {
                end = (int)mid - 1;
            }
        }
        return false;
    }
}
