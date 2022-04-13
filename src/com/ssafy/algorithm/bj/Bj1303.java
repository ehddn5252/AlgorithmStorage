package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map;
    static boolean[][] visit;
    static int count,wScore,bScore;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int colNum = Integer.parseInt(s[0]);
        int rowNum = Integer.parseInt(s[1]);
        map = new char[rowNum][colNum];
        visit = new boolean[rowNum][colNum];

        for(int i = 0; i< rowNum; ++i){
            String s1 = br.readLine();
            for(int j = 0; j< colNum; ++j){
                map[i][j]=s1.charAt(j);
            }
        }
        for(int i = 0; i< rowNum; ++i){
            for(int j = 0; j< colNum; ++j){
                if(!visit[i][j]){
                    count = 0;
                    visit[i][j]=true;
                    DFS(i,j,map[i][j]);
                    if(map[i][j]=='W') wScore+=Math.pow(count,2);
                    else bScore+=Math.pow(count,2);
                }
            }
        }
        System.out.println( wScore+" "+bScore);
    }
    private static void DFS(int nowI,int nowJ,char color){
        visit[nowI][nowJ]=true;
        count++;
        for(int i=0;i<4;++i){
            int nextI = nowI+d[i][0];
            int nextJ = nowJ+d[i][1];
            if(nextI>=0 && nextI< map.length && nextJ>=0 && nextJ<map[0].length && color==map[nextI][nextJ]){
                if(visit[nextI][nextJ]) continue;
                DFS(nextI,nextJ,color);
            }
        }
    }
}
