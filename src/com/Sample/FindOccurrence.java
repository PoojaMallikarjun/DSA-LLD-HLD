package com.Sample;

import java.util.Scanner;

public class FindOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();
        System.out.println("Enter digit to find:");
        int find = sc.nextInt();
        int count = 0;
        while(n > 0) {
            int num = n % 10;
            if(num == find)
                count ++;
            n = n/10;
        }
        System.out.println(find + " occurred " + count + " times!");
    }
}