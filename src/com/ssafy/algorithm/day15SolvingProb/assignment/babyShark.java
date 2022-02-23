package com.ssafy.algorithm.day15SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class babyShark {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int sharkLocation[];
    static int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visitMap;
    public static void main(String[] args) throws IOException {
        int fishNum = 0;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visitMap = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; ++j) {

                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 9) {
                    map[i][j]=0;
                    sharkLocation = new int[]{i, j,0,0};
                }
                else if(map[i][j]!=0){
                    fishNum+=1;
                }
            }
        }
        sharkLocation[3]=fishNum;
        BFS();
    }

    /*
    1. 상어 위치를 찾는다.
    2. 다음에 상어가 갈 수 있는 위치, 이동거리, 현재 남은 물고기 수를 q에 집어넣는다.
    3. BFS 로 찾는데, 멈추는 조건이 중요하다.
    

     */
    private static void BFS() {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(sharkLocation);
        int saveDistance=Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextX = d[i][0] + nowLocation[0];
                int nextY = d[i][1] + nowLocation[1];
                int moveDistance = nowLocation[2];
                int currentFishNum = nowLocation[3];
                if(saveDistance<=moveDistance) continue;

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (map[nextY][nextX] != 0) {
                        if (sharkSize > map[nextY][nextX]) {
                            map[nextY][nextX] = 0;
                            sharkSize += 1;
                            currentFishNum-=1;
                        }
                    }
                    if(currentFishNum==0){
                        if(saveDistance>moveDistance){
                            saveDistance=moveDistance;
                        }
                        System.out.println(moveDistance);
                    }
                    q.offer(new int[]{nextX, nextY, moveDistance,currentFishNum});
                }
            }
        }
    }
}
