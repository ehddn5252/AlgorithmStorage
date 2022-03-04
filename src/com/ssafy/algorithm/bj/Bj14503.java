package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj14503 {

    static int rowNum, colNum;
    static int robotRow, robotCol, direction;
    static int[][] map;
    static int[][] d = {{-1, 0}, {0, 1}, {+1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        robotRow = Integer.parseInt(s[0]);
        robotCol = Integer.parseInt(s[1]);
        direction = Integer.parseInt(s[2]);
        map= new int[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < colNum; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        cleaning();
        int result = 0;
        for(int i=0;i<map.length;++i){
            for(int j=0;j<map[0].length;++j){
                if(map[i][j]==-1){
                    result+=1;
                }
            }
        }
        System.out.println(result);
    }

    // 북: 0, 동: 1, 남: 2, 서:3
    private static void cleaning() {
        int cleanStack = 1;
        while (true) {
            // 청소안한 곳이라면 청소
            if(map[robotRow][robotCol]==0) map[robotRow][robotCol] = -1;

            // a. 왼쪽방향 확인한다. direction 에 cleanStack 을 뺀 것의 4로 나눳을 때 나머지는 로봇의 다음 청소할 위치가 된다.
            int nextI = robotRow + d[(8+direction - cleanStack) % 4][0];
            int nextJ = robotCol + d[(8+direction - cleanStack) % 4][1];
            if(!(nextI>=0 && nextI <rowNum && nextJ >=0 && nextJ <colNum)){
                cleanStack+=1;
                continue;
            }

            // 청소할 수 있다면(0 이라면) 왼쪽으로 이동하고 방향 변경한거 저장하고 한칸 전진
            if (map[nextI][nextJ] == 0) {
                robotRow = nextI;
                robotCol = nextJ;
                direction = ( 12+ direction - cleanStack ) % 4;
                cleanStack=1;
                continue;

                // b. 왼쪽 방향에 청소할 공간이 없으면 그 방향으로 회전
            } else {
                cleanStack += 1;
            }
            // c. 네방향 모두 청소가 이미 되어 있거나 벽인 경우
            if(cleanStack%4==1){
                // 한칸 후진시킨다.
                cleanStack+=1;
                robotRow = robotRow + d[(8+direction - cleanStack) % 4][0];
                robotCol = robotCol + d[(8+direction - cleanStack) % 4][1];
                if(map[robotRow][robotCol]==1){
                    // 후진 
                    break;
                }
                cleanStack=1;
            }
        }
    }
}
