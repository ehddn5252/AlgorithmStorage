package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1743 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map, d= {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit;
    static int count, ans;
    static int rowNum,colNum;

    public static void main(String[] args) throws IOException {
        // 세로, 가로, 음식물개수
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        int trashNum = Integer.parseInt(s[2]);
        map = new int[rowNum][colNum];
        visit = new boolean[rowNum][colNum];
        for(int i=0;i<trashNum;++i){
            s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            map[r-1][c-1]=1;
        }
        for(int i=0;i<rowNum;++i){
            for(int j=0;j<colNum;++j){
                if(!visit[i][j] && map[i][j]==1) {
                    count = 0;
                    DFS(i, j);
                    if(ans<count){
                        ans=count;
                    }
                }
            }
        }
        System.out.print(ans);
    }

    private static void DFS(int nowI, int nowJ) {
        count+=1;
        visit[nowI][nowJ]=true;
        for(int i=0;i<4;++i){
            int nextI = nowI + d[i][0];
            int nextJ = nowJ + d[i][1];
            if(nextI>=0 && nextI< rowNum && nextJ>=0 && nextJ<colNum){
                if(visit[nextI][nextJ]) continue;
                if(map[nextI][nextJ]==1){
                    DFS(nextI,nextJ);
                }
            }
        }
    }
}
