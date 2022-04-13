package com.ssafy.algorithm.newDay10ComThink2.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 구간합
public class SWEA5604 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[1001];
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        dp = calc(1000);
        for(int testCaseIndex = 1; testCaseIndex<=testCaseNum;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            long start = Long.parseLong(s[0]);
            long end = Long.parseLong(s[1]);

            System.out.println("#"+testCaseIndex+" "+(f(end)-f(start-1)));
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

    private static long f(long n){
        if(n<=0) return 0;
        else if(n<1000) return dp[(int)n];

        long tmp = n;
        int count = 0;
        while(tmp>=1){
            long rest = tmp%10;
            tmp/=10;
            count++;
        }
        long v =(long) Math.pow(10,count-1);

        return f((long)(n-1 - n%v)) + n/v *(n%v+1) + f(n%v);
    }

}
