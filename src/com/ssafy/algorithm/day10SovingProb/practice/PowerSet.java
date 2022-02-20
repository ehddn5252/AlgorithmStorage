package com.ssafy.algorithm.day10SovingProb.practice;

import java.util.Arrays;

public class PowerSet {
    static int n = 4;
    static int[] intArray = new int[]{1, 2, 3, 4};
    static int[] resultArray = new int[4];

    public static void main(String[] args) {

        powerSet(0, 0, n);
    }

    static void powerSet(int cnt, int i, int n) {
        if (cnt == n) {
            System.out.println(Arrays.toString(resultArray));
            return;
        }

        powerSet(cnt+1,i,n);
        resultArray[i] = intArray[cnt];
        powerSet(cnt+1,i+1,n);
        resultArray[i]=0;
    }
}
