package com.Sample.BinarySearch.Assignments.Hard;

import java.util.Arrays;

// https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
public class AggressiveCows {
    public static void main(String[] args) {
        int n = 5;
        int cows = 3;
        int nums[] = new int[]{1, 2, 8, 4, 9};
        System.out.println(findLargestMinDist(nums, n, cows));
    }

    private static int findLargestMinDist(int[] nums, int n, int cows) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[n - 1] - nums[0];
        int res = 0;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(canPlaceCows(nums, n, mid, cows)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static boolean canPlaceCows(int[] nums, int n, int mid, int cows) {
        int coOrd = nums[0];
        int c = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] - coOrd >= mid) {
                c++;
                coOrd = nums[i];
            }
            if(c == cows) {
                return true;
            }
        }
        return false;
    }
}
