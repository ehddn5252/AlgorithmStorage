package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2304 {
    static int[] dp1 = new int[1001];
    static int[] dp2 = new int[1001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split(" ");
            int left = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);
            dp1[left] = height;
            //dp1[left+1] = height;
            dp2[left] = height;
            //dp2[left+1] = height;
        }
        int saveNum=0;
        int dp1Length = dp1.length;
        int saveDp1 = 0;
        int saveDp2 = 0;

        for(int i=0;i<dp1Length;++i){
            if(dp1[i]<saveDp1) dp1[i]=saveDp1;
            else  saveDp1 = dp1[i];

            if(dp1Length-1-i>=0){
                if(dp2[dp1Length-1-i]<saveDp2) dp2[dp1Length-1-i]=saveDp2;
                else saveDp2 = dp2[dp1Length-1-i];
            }
        }

        int result = 0;
        for(int i=0;i<dp1Length;++i){
            result+=Math.min(dp1[i],dp2[i]);
        }
        System.out.println(result);
    }
}
