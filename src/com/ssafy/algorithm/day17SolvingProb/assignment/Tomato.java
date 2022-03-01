package com.ssafy.algorithm.day17SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum;
    static int[][] map;
    static boolean[][] visit;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");

        colNum = Integer.parseInt(s[0]);
        rowNum = Integer.parseInt(s[1]);
        map = new int[rowNum][colNum];
        visit = new boolean[rowNum][colNum];
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < rowNum; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < colNum; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        BFS(q);
        checkMap();
    }

    static void BFS(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            for (int i = 0; i < 4; ++i) {
                if(popped[2]>=maxValue){
                    maxValue=popped[2];
                }
                int nextI = popped[0] +d[i][0];
                int nextJ = popped[1] + d[i][1];
                if(nextI>=0 && nextI<rowNum && nextJ>=0 && nextJ<colNum){
                    if (map[nextI][nextJ]!=0) continue;
                    map[nextI][nextJ] = 1;
                    q.offer(new int[]{nextI,nextJ,popped[2]+1});
                }
            }
        }
    }
    static void checkMap(){
        for(int i=0;i<rowNum;++i){
            for(int j=0;j<colNum;++j){
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxValue);
    }
}
