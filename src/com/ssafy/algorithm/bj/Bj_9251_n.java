package com.ssafy.algorithm.bj;
// LCS
// 시간초과..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
public class Bj_9251_n {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    static int lcsLength = 0;

    public static void main(String[] args) throws IOException {
        String s1= br.readLine();
        String s2= br.readLine();
        dp = new int[s1.length()][s2.length()];

        // 기저조건 string1돌고 string2 돌면서 같은거 확인한다.
        for(int i=0;i<s1.length();++i){
            for(int j=0;j<s2.length();++j){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1;
                }
            }
        }
        for(int i=0;i<s1.length();++i){
            for(int j=0;j<s2.length();++j){
                if(dp[i][j]>=1){
                    dp[i][j]=check(i,j);
                    if(lcsLength<dp[i][j]){
                        lcsLength=dp[i][j];
                    }
                }
            }
        }
        System.out.println(lcsLength);
    }
    // 최대 1000자면 O(N^2) 으로 해결해야함.
    // check 를 하는 방법 중 시간이 적게 걸리는 방법을 찾아야 한다.
    // 일단 check는 패스
    static int check(int iMinusOne,int jMinusOne){
        int max = 0;
        for(int i=0;i<iMinusOne;++i){
            for(int j=0;j<jMinusOne;++j){
                if(max<dp[i][j]){
                    max=dp[i][j];
                }
            }
        }
        return max+1;
    }
}
