package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 길이가 100만이다.
    public static void main(String[] args) throws IOException {
        int N = 0, M = 0;
        String s = "";
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        s = br.readLine();
        StringBuilder b = new StringBuilder("I");

        for (int i = 0; i < N; ++i) {
            b.append("OI");
        }
        int ans = 0;
        int i = 0;
        int startI = 0;
        while (i <= M - b.length()) {
            int count = 0;
            for (int j = 0; j < b.length(); ++j) {
                if (s.charAt(i) == b.charAt(j)) {
                    count += 1;
                    i++;
                }
            }
            if (count == b.length()) {
                ans += 1;
            }
            startI+=1;
            i=startI;
        }
        System.out.println(ans);
    }
}
