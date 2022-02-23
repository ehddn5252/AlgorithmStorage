package com.ssafy.algorithm.day15SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int colNum, rowNum,K;
    static int[][] map;
    static boolean[][] visit;
    static int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for(int testCaseIndex=0;testCaseIndex<testCaseNum;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            colNum = Integer.parseInt(s[0]);
            rowNum = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);
            map = new int[rowNum][colNum];
            visit=new boolean[rowNum][colNum];
            for(int i=0;i<K;++i){
                s = br.readLine().split(" ");
                int y = Integer.parseInt(s[0]);
                int x = Integer.parseInt(s[1]);
                map[x][y]=1;
            }
            int count=1;// 2부터 시작
            for(int i=0;i<rowNum;++i){
                for(int j=0;j<colNum;++j){
                    if(map[i][j]==1){
                        count+=1;
                        DFS(i,j,count);
                    }
                }
            }
            System.out.println(count-1);
        }
    }


    static void DFS(int inputI, int inputJ, int count) {
        map[inputI][inputJ]=count;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + inputI;
            int nextJ = d[i][1] + inputJ;

            if (nextI >= 0 && nextI < rowNum && nextJ>=0 && nextJ<colNum) {
                if(visit[nextI][nextJ])continue;
                if(map[nextI][nextJ]==1){
                    DFS(nextI,nextJ,count);
                }
                visit[nextI][nextJ]=true;
            }
        }
    }
}
