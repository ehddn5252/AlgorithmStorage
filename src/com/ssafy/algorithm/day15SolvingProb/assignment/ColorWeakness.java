package com.ssafy.algorithm.day15SolvingProb.assignment;

// Bj 10026 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorWeakness {
    static int N;
    static int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[][] map1 = new int[N][N];
        int[][] map2 = new int[N][N];
        boolean[][] visit1 = new boolean[N][N];
        boolean[][] visit2 = new boolean[N][N];

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
                    visit1 = DFS(i, j, count1,map1,visit1);
                }
                if(!visit2[i][j]){
                    visit2[i][j]=true;
                    count2+=1;
                    visit2 = DFS(i, j, count2,map2,visit2);
                }
            }
        }
        System.out.println(count1+" "+count2);
    }

    static boolean[][] DFS(int inputI, int inputJ, int count, int[][] map, boolean[][] visit) {
        int currentColor = map[inputI][inputJ];
        map[inputI][inputJ] = count;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + inputI;
            int nextJ = d[i][1] + inputJ;
            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                if (visit[nextI][nextJ]) continue;
                if (map[nextI][nextJ] != currentColor) continue;
                visit[nextI][nextJ] = true;
                DFS(nextI, nextJ, count,map,visit);
            }
        }
        return visit;
    }
}
