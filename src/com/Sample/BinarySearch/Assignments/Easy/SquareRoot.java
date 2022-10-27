package com.Sample.BinarySearch.Assignments.Easy;

// https://leetcode.com/problems/sqrtx/
public class SquareRoot {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(mySqrt(x));
    }

    static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(mid * mid == x) {
                return (int)mid;
            } else if(mid * mid > x) {
                end = (int)mid - 1;
            } else {
                start = (int)mid + 1;
            }
        }
        return (int)end;
    }
}
