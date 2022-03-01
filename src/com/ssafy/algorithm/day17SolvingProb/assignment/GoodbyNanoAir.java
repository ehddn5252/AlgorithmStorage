package com.ssafy.algorithm.day17SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GoodbyNanoAir {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum, time;
    static int[][] map;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static ArrayList<AirCleaner> airCleaners = new ArrayList<AirCleaner>(2);
    static Queue<int[]> q = new LinkedList<>();
    static int airCleaner1MaxI, airCleaner2MinI;
    static int result;

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        time = Integer.parseInt(s[2]);
        map = new int[rowNum][colNum];


        int airCleanerIndex = 0;
        for (int i = 0; i < rowNum; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < colNum; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == -1) {
                    airCleaners.add(new AirCleaner(i, j));
                }
            }
        }

        AirCleaner airCleaner1 = airCleaners.get(0); // 반시계 방향으로 돌리기   우 상 좌 하
        AirCleaner airCleaner2 = airCleaners.get(1); // 시계 방향으로 돌리기     좌 상 우 하
        airCleaner1MaxI = airCleaner1.i;
        airCleaner2MinI = airCleaner2.i;
        // 여기까지 맵 만들었다.
        mainLogic();
    }


    static void mainLogic() {
        for (int i = 0; i < time; ++i) {
            inputDustToQ();
            diffuse();
            airCleanersBlow();
        }
        calc();
    }

    static void inputDustToQ() {
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (map[i][j] != 0 && map[i][j]!=-1) {
                    q.offer(new int[]{i, j, map[i][j]});
                }
            }
        }
    }

    static void diffuse() {
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextI = popped[0] + d[i][0];
                int nextJ = popped[1] + d[i][1];
                if (popped[2] < 5) continue;
                if (nextI >= 0 && nextI < rowNum && nextJ >= 0 && nextJ < colNum && map[nextI][nextJ] != -1) {
                    map[nextI][nextJ] += popped[2] / 5;
                    map[popped[0]][popped[1]] -= popped[2] / 5;
                }
            }
        }
    }

    private static void calc() {
        result = 2; // 에어컨자리 2개 빼줌
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    private static void airCleanersBlow() {
        AirCleaner airCleaner1 = airCleaners.get(0); // 반시계 방향으로 돌리기   우 상 좌 하
        AirCleaner airCleaner2 = airCleaners.get(1); // 시계 방향으로 돌리기     좌 상 우 하
        // 바닥이 rowNum, colNum

        // airCleaner1 취대 I값이 airCleaner1MaxI
        // airCleaner2 최소 I값이 airCleaner2MinI;
        map[airCleaner1.i][airCleaner1.j] = 0;
        map[airCleaner2.i][airCleaner2.j] = 0;

        // 에어컨1 아래로 이동
        for (int i = airCleaner1MaxI - 1; i >= 1; --i) {
            map[i][0] = map[i - 1][0];
        }

        // 에어컨1 왼쪽으로 이동
        for (int j = 1; j < colNum; ++j) {
            map[0][j - 1] = map[0][j];
        }

        // 에어컨1 위로 이동
        for (int i = 1; i <= airCleaner1MaxI; ++i) {
            map[i - 1][colNum - 1] = map[i][colNum - 1];
        }

        map[airCleaner1.i][airCleaner1.j] = 0;
        // 에어컨1 오른쪽으로 이동
        for (int j = colNum - 1; j >= 1; --j) {
            map[airCleaner1MaxI][j] = map[airCleaner1MaxI][j - 1];
        }

        // 에어컨2 위쪽으로 이동
        for (int i = airCleaner2MinI + 1; i < rowNum; ++i) {
            map[i - 1][0] = map[i][0];
        }
        // 에어컨2 왼쪽으로 이동
        for (int j = 1; j < colNum; ++j) {
            map[rowNum - 1][j - 1] = map[rowNum - 1][j];
        }
        // 에어컨2 아래로 이동
        for (int i = rowNum-1 ; i >=airCleaner2MinI+1 ; --i) {
            map[i][colNum - 1] = map[i - 1][colNum - 1];
        }
        map[airCleaner2.i][airCleaner2.j] = 0;
        // 에어컨2 오른쪽으로 이동
        for (int j = colNum - 1; j >= 1; --j) {
            map[airCleaner2MinI][j] = map[airCleaner2MinI][j - 1];
        }

        map[airCleaner1.i][airCleaner1.j] = -1;
        map[airCleaner2.i][airCleaner2.j] = -1;
    }

    static class AirCleaner {
        int i;
        int j;

        public AirCleaner(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
