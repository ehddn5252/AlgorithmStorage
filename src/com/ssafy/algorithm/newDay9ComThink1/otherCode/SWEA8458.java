package com.ssafy.algorithm.newDay9ComThink1.otherCode;

import java.io.*;
import java.util.*;

public class SWEA8458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int max = 0;
            int ans = 0;
            for (int j = 0; j < N; j++) {
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                arr[j] = Math.abs(x)+Math.abs(y);
                max=Math.max(max, arr[j]);
                if (j!=0) {
                    if (arr[j]%2!=arr[0]%2) {
                        ans=-1;
                    }
                }
            }

            if(ans!=-1) {
                int s=1;
                int sum=0;
                while(true) {
                    if(sum>=max) {
                        if ((sum-max)%2==0) ans=s-1;
                        else {
                            if (s%2==0) ans=s+1;
                            else ans=s;
                        }
                        break;
                    }
                    sum+=s++;
                }
            }
            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
    }
}