package com.ssafy.algorithm.newDay4Dp2LIS.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class personNetwork {
    static final int INF = 9999999;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N]; // 연결 정보가 담겨있는 2차원 배열
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    int inputValue = Integer.parseInt(st.nextToken());
                    if(inputValue==0 && i!=j){
                        map[i][j] = INF;
                    }
                    else{
                        map[i][j] = inputValue;
                    }
                }
            }
            System.out.println("#"+testCaseIndex+" "+mainLogic(map));
        }
    }

    static private int mainLogic(int[][] map) {
        //플루이드 워샬 사용한다.
        // 경유지
        for(int k=0;k<map.length;++k){
            // 출발지
            for(int i=0;i<map.length;++i){
                if(k==i) continue; // 출발지와 경유지가 같으면 패스
                // 도착지
                for(int j=0;j<map.length;++j){
                    if(i==j|| k==j) continue;
                    if(map[i][k]+map[k][j]<map[i][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<map.length;++i){
            int sum=0;
            for(int j=0;j<map[0].length;++j){
                sum+=map[i][j];
            }
            if(sum<min){
                min=sum;
            }
        }
        return min;
    }
}
