package com.ssafy.algorithm.newDay10ComThink2.others;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[100%4]=1;
        arr[1]=2;
        arr[2]=2;
        arr[3]=2;
        arr[4]=2;
        System.out.println(arr[0]);
    }
}
