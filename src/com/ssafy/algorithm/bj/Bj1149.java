package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] houses;

        int N = Integer.parseInt(br.readLine());

        houses = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                houses[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 1; i < N; ++i) {

            dp[i][0] = houses[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = houses[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = houses[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);

        }
        int min=99999999;
        for(int i=0;i<3;++i){
            if(min>dp[N-1][i]){
                min=dp[N-1][i];
            }
        }
        System.out.println(min);
    }
}
