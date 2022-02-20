package com.ssafy.algorithm.day11Backtracking.othersCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 형근님최적경로코드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, comX,comY,homeX,homeY, dMin;
    static int[][] cus;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            n = Integer.parseInt(br.readLine()); // 고객의 수
            st = new StringTokenizer(br.readLine(), " ");
            //회사 좌표
            comX = Integer.parseInt(st.nextToken());
            comY = Integer.parseInt(st.nextToken());
            //집 좌표
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            cus = new int[n][2];
            visited = new boolean[n];
            for(int i=0;i<n;i++) {
                cus[i][0] = Integer.parseInt(st.nextToken()); // 고객의 X좌표
                cus[i][1] = Integer.parseInt(st.nextToken()); // 고객의 Y좌표
            }

            dMin = Integer.MAX_VALUE;
            func(0,0,0,0);
            bw.write(String.format("#%d %d\n", t+1, dMin));
        }

        bw.flush();
        bw.close();
    }

    static void func(int cnt, int curX, int curY, int d) {
        if(d>dMin) { //이미 최소경로보다 경로가 김
            return;
        }

        if(cnt==n) {
            int distance = Math.abs(curX-homeX) + Math.abs(curY-homeY); //마지막 고객에서 집까지 거리 계산
            if(distance+d < dMin) {
                dMin = distance + d; //새로운 최소경로 저장
            }

        }else {
            if(cnt==0) { // 첫 고객 방문
                curX = comX; // 시작은 회사
                curY = comY;
            }
            for(int i=0;i<n;i++) {
                if(!visited[i]) {
                    int distance = Math.abs(curX-cus[i][0]) + Math.abs(curY-cus[i][1]); //거리 계산
                    visited[i] = true;
                    func(cnt+1, cus[i][0], cus[i][1], d+distance);
                    visited[i] = false;
                }
            }
        }
    }
}