package com.ssafy.algorithm.newDay5SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k, c, d, N;
    static int[] kindL, dish;
    public static void main(String[] args) throws IOException {
        // input
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 접시의 수
        d = Integer.parseInt(s[1]); // 초밥 가짓수
        kindL =new int[d+1];
        k = Integer.parseInt(s[2]); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(s[3]); // 쿠폰 번호
        dish = new int[N+k];
        // 초밥을 넣는다.
        for (int i = 0; i < N; ++i) {
            int item = Integer.parseInt(br.readLine());
            dish[i]=item;
        }
        for(int i=0;i<k;++i){
            dish[N+i]= dish[i];
        }
        kindL[c]=1;
        int kindV = 1;
        int ans=1;
        for(int i=0;i<N+k;++i){
            if(i<k){
                kindL[dish[i]]+=1;
                if(kindL[dish[i]]==1){
                    kindV++;
                }
            }
            else{
                kindL[dish[i-k]]-=1;
                if(kindL[dish[i-k]]==0){
                    kindV--;
                }
                kindL[dish[i]]+=1;
                if(kindL[dish[i]]==1){
                    kindV++;
                }
            }
            if(ans<kindV) ans=kindV;
        }
        System.out.println(ans);
    }
}
