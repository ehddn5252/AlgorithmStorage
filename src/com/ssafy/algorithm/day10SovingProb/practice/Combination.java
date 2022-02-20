package com.ssafy.algorithm.day10SovingProb.practice;

import java.util.Arrays;

public class Combination {
    static int s;
    static int[] intArray = new int[]{1,2,3,4};
    static int[] resultArray = new int[2];
    public static void main(String[] args) {
        int n = intArray.length;
        int r= 2;

        combination(0,0,n,r);
    }

    static void combination(int cnt, int start,int n, int r){
        if(cnt==r){
            System.out.println(Arrays.toString(resultArray));
            return;
        }

        for(int i=start;i<n;++i){
            resultArray[cnt]=i;
            combination(cnt+1,i+1,n,r);
        }

    }
}
