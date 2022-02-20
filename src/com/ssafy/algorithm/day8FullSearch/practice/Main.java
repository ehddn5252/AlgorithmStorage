package com.ssafy.algorithm.day8FullSearch.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[] sin; //곱
    static int[] ss; //합
    static int res = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        sin = new int[n]; ss = new int[n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            sin[i] = Integer.parseInt(st.nextToken());
            ss[i] = Integer.parseInt(st.nextToken());
        }
        making_food(0, 0, 1, 0);
        System.out.println(res);
    }
    public static void making_food(int input_cnt, int cnt, int sin_sum, int ss_sum) {
        if(cnt == n) {
            if(input_cnt !=0) {
                res = Math.min(res, Math.abs(sin_sum-ss_sum));
            }
            return;
        }
        making_food(input_cnt, cnt+1, sin_sum, ss_sum); //cnt번째 있는 재료 넣지 않은 것
        making_food(input_cnt+1, cnt+1, sin_sum*sin[cnt], ss_sum+ss[cnt]);
    }


}
