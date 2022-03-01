package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11050 {
    static int N,K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] s  = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        int ans=1;
        for(int i=N;i>N-K;--i){
            ans*=i;
        }
        for(int i=1;i<=K;++i){
            ans/=i;
        }
        System.out.println(ans);
    }
}
