package com.Sample.LinearSearch;

// You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the
// ith customer has in the jth bank. Return the wealth that the richest customer has.
//A customer's wealth is the amount of money they have in all their bank accounts.
// The richest customer is the customer that has the maximum wealth.

// Input: accounts = [[1,5],[7,3],[3,5]]
// Output: 10

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] arr = {{1,5,8},{7,4},{7,5}};
        System.out.println("Max wealth = " + findMaxWealth2(arr));
    }

    private static int findMaxWealth(int[][] accounts) {
        int maxSum = Integer.MIN_VALUE;
        for (int[] person: accounts) {
            int sum = 0;
            for (int account: person) {
                sum += account;
            }
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

//    Using Streams(not very fast)
    private static int findMaxWealth2(int[][] accounts) {
        int maxWealth = 0;
        for (var customer: accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(customer).sum());
        }
        return maxWealth;
    }
}
