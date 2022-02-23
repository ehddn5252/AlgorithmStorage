package com.ssafy.algorithm.bj;
// LCS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
// 최대 1000자면 O(N^2) 으로 해결해야함.  dp 2차원?
public class Bj_9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if (s1.charAt(i) == s2.charAt(j))  dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
