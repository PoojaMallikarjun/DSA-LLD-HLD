package com.Sample;

import java.util.ArrayList;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 45342;
        int rev = 0;
        while( n > 0 ) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        System.out.println(rev);
        ArrayList<Integer> arr = new ArrayList<>();
    }
}
