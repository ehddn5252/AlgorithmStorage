package com.ssafy.algorithm.newDay5SolvingProb.others;

import java.io.*;
import java.util.*;

public class jungwol2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int type= 1;
        int answer = 0;
        int[] sushi = new int[N]; //접시 수
        int[] eat = new int[d]; // 초밥 종류 수만큼 있음
        eat[c-1]=1; //쿠폰
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine())-1;
        }
        for (int i = 0; i < N; i++) {
            if(i>=k) {
                eat[sushi[i-k]]--;
                if(eat[sushi[i-k]]==0) type--;
            }
            if (eat[sushi[i]]==0) {
                type++;
            }
            eat[sushi[i]]++;
            answer=Math.max(answer, type);
        }

        System.out.print(answer);
    }
}