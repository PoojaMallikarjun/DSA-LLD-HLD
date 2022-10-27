package com.Sample.BinarySearch.Assignments.Easy;

public class GuessNumberHigherOrLower {
    static int n;
    public static void main(String[] args) {
        int pick = 10;
        n = 8;
        System.out.println(guessNumber(pick));
    }

    static int guess(int num) {
        if(n == num) {
            return 0;
        } else if(n > num) {
            return 1;
        } else {
            return -1;
        }
    }
    static int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
