package com.ssafy.algorithm.day15SolvingProb.assignment;

// Bj 10026/ 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorWeakness_1 {
    static int N;
    static int[][] map1; // 아닌 사람
    static int[][] map2; // 적록색약
    static boolean[][] visit1;
    static boolean[][] visit2;
    static int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map1 = new int[N][N];
        map2 = new int[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];

        // map1, map2 초기화
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            int length = s.length();
            for (int j = 0; j < length; ++j) {
                char color = s.charAt(j);
                if (color == 'R') {
                    map1[i][j] = -1;
                    map2[i][j] = -1;
                } else if (color == 'G') {
                    map1[i][j] = -2;
                    map2[i][j] = -1;
                } else if (color == 'B') {
                    map1[i][j] = -3;
                    map2[i][j] = -3;
                }
            }
        }
        int count1=0;
        int count2=0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if(!visit1[i][j]){
                    visit1[i][j]=true;
                    count1+=1;
                    DFS1(i, j, count1);
                }
                if(!visit2[i][j]){
                    visit2[i][j]=true;
                    count2+=1;
                    DFS2(i, j, count2);
                }
            }
        }
        System.out.println(count1+" "+count2);
    }

    static void DFS1(int inputI, int inputJ, int count) {
        int currentColor = map1[inputI][inputJ];
        map1[inputI][inputJ] = count;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + inputI;
            int nextJ = d[i][1] + inputJ;
            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                if (visit1[nextI][nextJ]) continue;
                if (map1[nextI][nextJ] != currentColor) continue;
                DFS1(nextI, nextJ, count);
                visit1[nextI][nextJ] = true;
            }
        }
    }

    static void DFS2(int inputI, int inputJ, int count) {
        int currentColor = map2[inputI][inputJ];
        map2[inputI][inputJ] = count;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + inputI;
            int nextJ = d[i][1] + inputJ;
            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                if (visit2[nextI][nextJ]) continue;
                if (map2[nextI][nextJ] != currentColor) continue;
                DFS2(nextI, nextJ, count);
                visit2[nextI][nextJ] = true;
            }
        }
    }
}
