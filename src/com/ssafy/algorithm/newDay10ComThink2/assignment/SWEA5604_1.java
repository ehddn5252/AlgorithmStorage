package com.ssafy.algorithm.newDay10ComThink2.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구간합
public class SWEA5604_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[1000];
    public static void main(String[] args) throws IOException {
        int testCaseNum = 1;//Integer.parseInt(br.readLine());
        dp = calc(1000);
        for(int testCaseIndex = 1; testCaseIndex<=testCaseNum;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            long start = Integer.parseInt(s[0]);
            long end = Integer.parseInt(s[1]);

            System.out.println("#"+testCaseIndex+" "+(mainLogic(end)-mainLogic(start-1)));
        }
    }
    private static long[] calc(long num){
        long[] dp = new long[(int)num+1];
        long ret = 0;
        for(int i=1;i<=num;++i){
            int tmp=i;
            while(tmp>=1){
                ret+=tmp%10;
                tmp/=10;
            }
            dp[i]=ret;
        }
        return dp;
    }

    private static long g(long n){
        long tmp = n;
        int count = 0;
        final int F9 = 45;
        while(tmp>=1){
            long rest = tmp%10;
            tmp/=10;
            count++;
        }
        long v = (long)Math.pow(10,count-1);
        return n/v *(n%v+1) + f(n%v);
    }

    private static long f(long n){
        if(n<1000){
            return dp[(int)n];
        }

        long tmp = n;
        int count = 0;
        while(tmp>=1){
            long rest = tmp%10;
            tmp/=10;
            count++;
        }
        double v = Math.pow(10,count-1);

        return f((long)(n-1 - n%v)) +g(n);
    }

    private static long mainLogic(long num) {
        long ret = 1L;
        long tmp = num;
        int count = 0;
        final int F9 = 45;
        while(tmp>=1){
            long rest = tmp%10;
            tmp/=10;
            count++;
        }
        double v = Math.pow(10,count-1);

        System.out.println(count);
        // 배열의 최대 크기는 21억 2^31 -1 까지
        /*
        1. F(9) = 45
        2. F(99) = 20 * F(9)
        3. F(999) = 300 * F(9)
        4. F(9999) = 4000 * F(0)
        F(n) = F(n-1-n%v) + G(n)
        G(n) = n/v * (n% v + 1) + F(n%v)
        F(9) = 0 * 10 + F(9)
        F(19) = 1 * 10 + 2*F(9)
        F(29) = (1+2) * 10 + 3F(9)
        F(499) = F(499 - 99 - 1) = F(399)
        F(n) = F(n-1L-n%v) + G(n)

        G(425) = G((4-1)*100 + 25)
        G(n) = F(n%v)
        G(525) = F(25)
        G(99) = F(9)
         */
        return ret;

    }
}
