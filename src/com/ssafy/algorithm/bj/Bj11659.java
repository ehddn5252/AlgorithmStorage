package com.ssafy.algorithm.bj;

import java.io.*;

public class Bj11659 {
    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] nums = new int[100000];
    static int[] dp = new int[100000];
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");

        for(int i=0;i<s.length;++i){
            nums[i]=Integer.parseInt(s[i]);
        }
        dp[0]=nums[0];
        for(int i=1;i<s.length;++i){
            dp[i]=dp[i-1]+nums[i];
        }

        // 1회로 끝내야 한다. 그래서 dp로 만드는 것이 best 인듯

        for(int i=0;i<M;++i){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0])-1;
            int end = Integer.parseInt(s[1])-1;
            int ans=0;
            if(start==0){
                ans = dp[end];
            }
            else if(start==end){
                ans = dp[start] - dp[start-1];
            }
            else{
                ans=dp[end]-dp[start-1];
            }
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }
}
