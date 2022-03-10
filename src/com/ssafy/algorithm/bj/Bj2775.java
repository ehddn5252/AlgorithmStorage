package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2775 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int d[][] = new int[15][15];

        for (int i = 0; i < 15; ++i) {
            d[0][i] = i;
        }

        for (int i = 1; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                for(int k=0;k<=j;++k){
                    d[i][j] += d[i - 1][k];
                }
            }
        }

        int k, n;
        for (int i = 0; i < testCase; ++i) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            System.out.println(d[k][n]);
        }
    }
}
