package com.ssafy.algorithm.others;

import java.io.*;
import java.util.*;

public class BJ10971 {

    static int N,map[][],dp[][];
    static int INF=987654321;
    static int ss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        ss = (1<<N)-1;
        map = new int[N][N];
        dp= new int[N][ss];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findP(0,1));
    }

    /*
    도시 i에서 j로 가는 최소 비용을 찾는 문제이다.
    만약에
     */

    static int findP(int end, int visit) {

        if (visit==ss) {
            if(map[end][0]==0) return INF;
            else return map[end][0];
        }

        if (dp[end][visit]!=INF) return dp[end][visit];

        for (int i = 0; i < N; i++) {
            int next= visit | (1<<i);
            if(map[end][i] ==0 || (visit & (1<<i)) != 0) continue;
            dp[end][visit]=Math.min(findP(i,next)+map[end][i], dp[end][visit]);
        }
        return dp[end][visit];
    }
}