package com.ssafy.day10SovingProb.practice;

import java.util.Arrays;

public class Permutation {
    static int N = 4;
    static int r = 2;
    static int[] numArray = new int[r];
    static boolean[] visited = new boolean[4];
    static int[] intArray = new int[]{1, 2, 3, 4};

    public static void main(String[] args) {
        permutation(0,4,2);
    }
    static void permutation(int cnt,int n,int r){
        // 종료 조건
        if (cnt==r){
            printAll();
            return;
        }

        for(int i=0;i<n;++i){
            if(visited[i]) continue;
            visited[i] = true;
            numArray[cnt] = intArray[i];
            permutation(cnt+1,n,r);
            visited[i] = false;
        }
    }


    static void printAll(){
        System.out.println("===============");
        System.out.println(Arrays.toString(numArray));
    }
}
