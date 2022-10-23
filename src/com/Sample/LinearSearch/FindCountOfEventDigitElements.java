package com.Sample.LinearSearch;

// Find the count of even number elements in an integer array
public class FindCountOfEventDigitElements {
    public static void main(String[] args) {
        int[] arr = {5555, 0, -1100, 2222};
        System.out.println(findCount(arr));
    }

    private static int findCount(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int element: arr) {
            System.out.println("len:"+countDigits2(element));
            if(countDigits2(element) % 2 == 0)
                count ++;
        }
        return count;
    }

    private static int countDigits(int num) {
        int count = 0;
        if(num < 0)
            num = num * -1;
        if(num == 0)
            return 1;
        while(num > 0) {
            count ++;
            num /= 10;
        }
        return count;
    }

//    Shortcut to find number of digits
    private static int countDigits2(int num) {
        if(num < 0)
            num = num * -1;
        if(num == 0)
            return 1;
        return (int)(Math.log10(num)) + 1;
    }
}
