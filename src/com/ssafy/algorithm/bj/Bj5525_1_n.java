package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5525_1_n {
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
            int add=0;
            int count = 0;
            for (int j = 0; j < b.length(); ++j) {
                if (s.charAt(i) == b.charAt(j)) {
                    count += 1;
                    i++;
                }
                else{
                    break;
                }
            }
            if (count == b.length()) {
                ans += 1;
                while (i+1<=s.length()-1 && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                    ans += 1;
                    add += 2;
                    i += 2;
                }
                if(add!=0){
                    add+=1;
                }
            }
            startI = Math.max(startI+1,startI+add);
            i = startI;
        }
        System.out.println(ans);
    }
}
