package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj2636_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum, time;
    static int[][] map;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> q = new LinkedList<int[]>();
    static List<Integer> l = new ArrayList<Integer>();
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        map = new int[rowNum][colNum];
        visit = new boolean[rowNum][colNum];

        // 가장자리에 있는 것들만 먼저 없어진다. 이걸 어떻게 찾나?
        // 왼쪽끝에
        int splitFlag = 2;
        for (int i = 0; i < rowNum; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < colNum; ++j) {
                map[i][j] = Integer.parseInt(s[j]);

            }
        }
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (map[i][j] == 0) {
                    // 0이면
                    BFS1(i, j, splitFlag);
                    splitFlag += 1;
                }
            }
        }
        // 완료

        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (map[i][j] == 1) {
                    if(isOutside(i,j))q.offer(new int[]{i, j, 1});
                }
            }
        }

        DFS();

        System.out.println(l.get(l.size() - 1));
        System.out.println(l.size());
    }

    static void BFS1(int firstI, int firstJ, int splitFlag) {
        Queue<int[]> settingQ = new LinkedList<int[]>();
        settingQ.offer(new int[]{firstI,firstJ,splitFlag});
        while (!settingQ.isEmpty()) {
            int[] polled = settingQ.poll();
            for (int i = 0; i < 4; ++i) {
                int nextI = d[i][0] + polled[0];
                int nextJ = d[i][1] + polled[1];
                if (nextJ >= 0 && nextJ < colNum && nextI >= 0 && nextI < rowNum) {
                    if (map[nextI][nextJ] == 0) {
                        map[nextI][nextJ] = polled[2];
                        settingQ.offer(new int[]{nextI, nextJ, polled[2]});
                    }
                }
            }
        }
    }

    static boolean isOutside(int nowI, int nowJ) {
        boolean ret = false;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + nowI;
            int nextJ = d[i][1] + nowJ;
            if (nextJ >= 0 && nextJ < colNum && nextI >= 0 && nextI < rowNum) {
                if (map[nextI][nextJ] == 2) {
                    ret = true;
                    break;
                }
            }
            else{
                return true;
            }
        }
        return ret;
    }

    static void DFS() {
        while (!q.isEmpty()) {
            int[] position = q.poll();
            if (position[2] > l.size()) l.add(1);
            else {
                // 시간별 치즈의 개수
                int tmp = l.get(position[2] - 1);
                l.set(position[2] - 1, tmp + 1);
            }

            for (int i = 0; i < 4; ++i) {
                int nextI = d[i][0] + position[0];
                int nextJ = d[i][1] + position[1];
                if (nextJ >= 0 && nextJ < colNum && nextI >= 0 && nextI < rowNum) {
                    if (map[nextI][nextJ] == 1) {
                        if (isOutside(nextI, nextJ)) {
                            map[nextI][nextJ] = 2;
                            q.offer(new int[]{nextI, nextJ, position[2] + 1});
                        }
                    }
                }
            }
        }
    }
}