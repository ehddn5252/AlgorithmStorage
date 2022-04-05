package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj2636_2 {

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
        for(int i=0;i<100;++i){
            l.add(0);
        }
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
                    BFS(i, j, splitFlag);
                    splitFlag += 1;
                }
            }
        }
        // 완료

        int count=1;
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (!visit[i][j]) {
                    if(map[i][j]==1 && isOutside(i, j)) {
                        DFS(i, j, count);
                        count += 1;
                    }
                }
            }
        }
        for(int i=1;i<l.size();++i){
            System.out.println(l.get(i));

            if (l.get(i)==0){
                System.out.println(l.get(i-1));
                System.out.println(i);
                break;
            }
        }
    }

    static void DFS(int initI, int initJ, int count) {
        // 시간별 치즈의 개수
        int tmp = l.get(count);
        l.set(count, tmp + 1);
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + initI;
            int nextJ = d[i][1] + initJ;
            if (nextJ >= 0 && nextJ < colNum && nextI >= 0 && nextI < rowNum) {
                if (map[nextI][nextJ] == 1 && !visit[nextI][nextJ]) {
                    if (isOutside(nextI, nextJ)) {
                        visit[nextI][nextJ] = true;
                        DFS(nextI, nextJ, count);
                        map[nextI][nextJ] = 2;
                    }
                }
            }
        }
    }

    static void BFS(int firstI, int firstJ, int splitFlag) {
        Queue<int[]> settingQ = new LinkedList<int[]>();
        settingQ.offer(new int[]{firstI, firstJ, splitFlag});
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
            } else {
                return true;
            }
        }
        return ret;
    }

}
