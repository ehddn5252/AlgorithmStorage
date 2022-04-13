package com.ssafy.algorithm.newDay9ComThink1.otherCode;
import java.io.*;
import java.util.*;

public class SWEA8458_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int max = 0;
            for (int j = 0; j < N; j++) {
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                arr[j] = Math.abs(x)+Math.abs(y);
                max=Math.max(max, arr[j]);
            }
            int s=1;
            int sum=0;
            while(true) {
                if(sum>=max) break;
                sum+=s++;
            }
            int ans=(sum-arr[0])%2;

            for (int j = 1; j < N; j++) {
                if (ans!=(sum-arr[j])%2) {
                    ans=-1;
                    break;
                }
            }

            if(ans!=-1) {
                while(ans%2!=0) {
                    ans+=s++;
                }
                ans=s-1;
            }

            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
    }
}