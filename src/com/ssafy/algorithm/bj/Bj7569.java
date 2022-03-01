package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
0. 준비물: 3차원 배열 map , 2차원 d 배열, queue q
1. 3차원 배열을 만든다.
2. 2차원 d 함수를 만든다. 이는 동서남북, 위 아래를 확인한다.
3. BFS 로 주변을 확인하고 익지 않은 토마토가 없으면 pass 익지 않은 토마토가 있으면 map 에 1로 표시 해주고 q 에 넣어준다..


 */

public class Bj7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int colNum, rowNum, height; // M, N, H
    static int maxValue;
    static int[][][] map;
    static int[][] d = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        colNum = Integer.parseInt(s[0]);
        rowNum = Integer.parseInt(s[1]);
        height = Integer.parseInt(s[2]);
        map = new int[height][rowNum][colNum];
        Queue<int[]> q = new LinkedList<int[]>();
        for (int h = 0; h < height; ++h) {
            for (int i = 0; i < rowNum; ++i) {
                s = br.readLine().split(" ");
                for (int j = 0; j < colNum; ++j) {
                    map[h][i][j] = Integer.parseInt(s[j]);
                    if(map[h][i][j]==1){
                        q.offer(new int[]{h, i, j, 0});
                    }
                }
            }
        }
        BFS(q);
        checkMap();
    }

    static void BFS(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            if (popped[3] >= maxValue) {
                maxValue = popped[3];
            }
            for (int i = 0; i < 6; ++i) {
                int nextH = popped[0] + d[i][0];
                int nextI = popped[1] + d[i][1];
                int nextJ = popped[2] + d[i][2];
                if (nextH >= 0 && nextH < height && nextI >= 0 && nextI < rowNum && nextJ >= 0 && nextJ < colNum) {
                    if (map[nextH][nextI][nextJ] != 0) continue;
                    map[nextH][nextI][nextJ]=1;
                    q.offer(new int[]{nextH, nextI, nextJ, 1+popped[3]});
                }
            }
        }
    }


    static void checkMap(){
        for(int h=0;h<height;++h){
            for(int i=0;i<rowNum;++i){
                for(int j=0;j<colNum;++j){
                    if(map[h][i][j]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(maxValue);
    }
}

