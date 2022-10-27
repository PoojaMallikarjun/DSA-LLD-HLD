package com.Sample.BinarySearch.Assignments.Easy;

public class VersionControl {
    static int bad = 4;

    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }

    static boolean isBadVersion(int num) {
        if(num >= bad) {
            return true;
        }
        return false;
    }
    static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

}
