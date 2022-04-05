package com.ssafy.algorithm.bj;
// 케빈 베이컨의 법칙
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int[][] map = new int[N+1][N+1];

        for(int i=0;i<E;++i){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            map[start][end]=1;
            map[end][start]=1;
        }
        for(int i=1;i<N+1;++i){
            for(int j=1;j<N+1;++j){
                if(map[i][j]==0 && i!=j){
                    map[i][j]=INF;
                }
            }
        }
        // 플로이드 워샬
        for(int k=1;k<N+1;++k){
            for(int i=1;i<N+1;++i){
                if(i==k) continue;
                for(int j=1;j<N+1;++j){
                    if(k==j || i==j) continue;
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }
        int ans =999999;
        int k_b_min =999999;
        for(int i=1;i<N+1;++i){
            int k_b=0;
            for(int j=1;j<N+1;++j){
                k_b+=map[i][j];
            }
            if(k_b_min >k_b){
                k_b_min = k_b;
                ans=i;
            }
        }

        System.out.println(ans);
    }
}
