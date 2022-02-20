package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bJ2559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static int maxValue=Integer.MIN_VALUE;
    static int[] intArray,dp;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        s= br.readLine().split(" ");
        intArray = new int[N];
        dp = new int[N+1];
        for(int i=0;i<N;++i){
            intArray[i]=Integer.parseInt(s[i]);
        }
        for(int i=0;i<K;++i){
            dp[i] = intArray[i];
        }

        for(int i=K;i<N+1;++i){
            for(int j=i-K;j<i;++j){
                dp[i] += intArray[j];
            }
            if(dp[i]>=maxValue){
                maxValue = dp[i];
            }
        }
        System.out.println(maxValue);
    }
}
