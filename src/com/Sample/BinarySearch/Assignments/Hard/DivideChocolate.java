package com.Sample.BinarySearch.Assignments.Hard;

import java.util.Arrays;

public class DivideChocolate {
    public static void main(String[] args) {
        int[] sweetness = new int[]{1, 2, 3, 4, 5};
        int k = 3;

        System.out.println(divideChocolate(sweetness, k));
    }

    private static int divideChocolate(int[] sweetness, int k) {
        int low = 1;
        int high = Arrays.stream(sweetness).sum() / (k + 1);

        while(low < high) {
//            int mid = low + ((high - low) / 2) + 1;
            int mid = (low + high + 1) / 2;
            if(canSplit(sweetness, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean canSplit(int[] sweetness, int k, int mid) {
        int chunks = 0, sum = 0;

        for(int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if(sum >= mid) {
                chunks++;
                sum = 0;
            }
        }
        return chunks >= k + 1;
    }
}
