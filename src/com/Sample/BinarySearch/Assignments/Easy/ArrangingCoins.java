package com.Sample.BinarySearch.Assignments.Easy;

// https://leetcode.com/problems/arranging-coins/
// Go through the 2 submissions to identify both iterative and Binary Search approach.
// https://leetcode.com/problems/arranging-coins/submissions/
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }

    static int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            long coinsUsed =  mid * (mid + 1) / 2;
            if(coinsUsed == n) {
                return (int)mid;
            } else if(coinsUsed > n) {
                end = (int)mid - 1;
            } else {
                start = (int)mid + 1;
            }
        }
        return end;
    }
}
