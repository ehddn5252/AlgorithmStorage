package com.ssafy.algorithm.newDay9ComThink1.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA5607_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex = 1;testCaseIndex<= testCaseNum;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            System.out.println("#"+testCaseIndex+" "+mainLogic(n,r,1234567891));
        }
    }
    
    // 페르마의 소정리
    private static long mainLogic(int n,int r, int p) {
        if (r == 0)
            return 1L;
        long[] fac = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; ++i)
            fac[i] = fac[i - 1] * i % p;
        return (fac[n] * power(fac[r]*fac[n - r], p - 2, p) % p ) % p;
    }

    // sqrt 하면서 모듈러 공간에서 곱하게 해준다.
    private static long power( long x, long y, long p){
        long res = 1L;
        x = x%p;
        while(y>0){
            if (y%2==1)
                res = (res*x)%p;
            y= y>>1;
            x = (x*x) %p;
        }
        return res;
    }
}