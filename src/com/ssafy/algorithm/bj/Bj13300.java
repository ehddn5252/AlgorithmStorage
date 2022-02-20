package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj13300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] info = new int[7][2];

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            s = br.readLine().split(" ");
            int gender = Integer.parseInt(s[0]);
            int grade = Integer.parseInt(s[1]);
            info[grade][gender] += 1;
        }
        for (int i = 1; i < 6+1; ++i) {
            for (int j = 0; j < 2; ++j) {
                ans += Math.ceil((float)info[i][j] / K);
            }
        }
        System.out.println(ans);
    }
}
