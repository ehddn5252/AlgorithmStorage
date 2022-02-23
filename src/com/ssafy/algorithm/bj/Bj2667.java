package com.ssafy.algorithm.bj;


// 단지 번호 붙이기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int[][] d = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        visit = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int count = 2;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 1) {
                    DFS(i, j, count);
                    count += 1;
                }
            }
        }

        counts = new int[count];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 0) continue;
                counts[map[i][j]] += 1;
            }
        }
        Arrays.sort(counts);
        System.out.println(count - 2);
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] != 0) {
                System.out.println(counts[i]);
            }
        }
    }

    static void DFS(int inputI, int inputJ, int count) {
        map[inputI][inputJ] = count;
        for (int i = 0; i < 4; ++i) {
            int nextI = d[i][0] + inputI;
            int nextJ = d[i][1] + inputJ;
            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                if (visit[nextI][nextJ]) continue;
                if (map[nextI][nextJ] == 1) {
                    //map[nextI][nextJ] = count;
                    DFS(nextI, nextJ, count);
                    visit[nextI][nextJ] = true;
                }
            }
        }
    }
}
