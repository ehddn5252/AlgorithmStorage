package com.ssafy.algorithm.day15SolvingProb.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2533_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for (int i = 0; i < N - 1; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            dp[a]+=1;
            dp[b]+=1;
        }
        test(dp);
    }

    static void test(int[] dp) {
        float count2 = 0;
        float count3 = 0;
        for (int i = 1; i < dp.length; ++i) {
            if (dp[i] == 2) {
                count2 += 0.5;
            }
            else if (dp[i] >= 3) {
                count3 += dp[i]/2 * 1.0;
            }
        }
        System.out.println((int)(Math.ceil(count2+count3)));
    }
}